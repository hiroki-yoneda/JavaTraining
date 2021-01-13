package js8ri.ch08.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilterWords {

	public static List<String> getWords(){
		try {
			return Arrays.asList(
			        new String(
			                Files.readAllBytes(Paths.get("src/main/java/js8ri/ch08/ex05/Inquiry_about_room_rate.txt"))
			        ).split("[\\P{L}]+")
			);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static void useStream(List<String> words) {
		long start = System.nanoTime();
		long count = words.stream().filter(s -> s.length() > 5).count();
        long end = System.nanoTime();
        System.out.println("count : " + count + " Time : " + (end - start) + " nanosecond");
	}

	public static void useRemoveIf(List<String> words) {
		List<String> words_copy = new ArrayList<String>(words);
		long start = System.nanoTime();
		words_copy.removeIf(s -> s.length() <= 5);
		int count = words_copy.size();
        long end = System.nanoTime();
        System.out.println("count : " + count + " Time : " + (end - start) + " nanosecond");
	}

	public static void main(String[] args) {
		List<String> words = getWords();
		useStream(words);     // count : 18 Time : 2832183 nanosecond
		useRemoveIf(words);   // count : 18 Time : 781606 nanosecond
	}

}
