package js8ri.ch06.ex06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordsReader {

	static String[] fileReader(File file) {
		try {
			// 余談: https://en.wikipedia.org/wiki/List_of_file_signatures
			// P{L}: http://www.regular-expressions.info/unicode.html#prop
			return new String(Files.readAllBytes(file.toPath())).split("[\\P{L}]+");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	static void ReadWords(File[] files) {
		ConcurrentHashMap<String, Set<File>> wordMap = new ConcurrentHashMap<String, Set<File>>();
		ExecutorService pool = Executors.newFixedThreadPool(files.length);
		for(File f: files) {
			pool.submit(() -> {
				String[] words = fileReader(f);
                for (String word : words) {
                	// HashSet を毎回 new しなくてよい
                	Set<File> file = wordMap.computeIfAbsent(word, s -> new HashSet<>());
                    file.add(f);
                }
			});
		}
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Result");
		wordMap.forEach((w, f) -> { System.out.println(f + " : " + w); });
	}

	public static void main(String[] args) {
		File[] files = {
				new File("src/main/java/js8ri/ch06/ex05/Sample01.txt"),
				new File("src/main/java/js8ri/ch06/ex05/Sample02.txt"),
				new File("src/main/java/js8ri/ch06/ex05/Sample03.txt")
		};
		ReadWords(files);
	}
}
