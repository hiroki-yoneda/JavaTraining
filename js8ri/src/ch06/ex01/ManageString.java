package js8ri.ch06.ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class ManageString {

	public static String getLongWord(String[] words) {
		AtomicReference<String> longest = new AtomicReference<String>("");
		// https://java.keicode.com/lang/multithreading-executor.php
		ExecutorService pool = Executors.newCachedThreadPool();
		for(String word: words) {
			pool.submit(() -> {
				longest.accumulateAndGet(word, (s1, s2) -> {
					System.out.println("s1: " + s1 + " s2: " + s2);  // なにしているかいまいちわかっていない
					return s1.length() > s2.length() ? s1 : s2;
				});
			});
		}
		pool.shutdown();

		return longest.get();
	}

	public static void main(String[] args) {
		String[] words = {"1", "333", "22", "4444", "666666","55555"};
		System.out.println(getLongWord(words));
	}
}
