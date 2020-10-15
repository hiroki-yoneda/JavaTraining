package js8ri.CH02.ex01;

import java.util.Arrays;
import java.util.List;

// 単一カウンタを更新するためにスレッドを使用したくない理由は？
// スレッドセーフを保証するのが難しいから？
public class ForLoopParallel {
	static int count = 0;

	public static void main(final String[] args) {
		List<String> words = Arrays.asList("aaaaaaaaaaaa", "bbbbbbbbbbbbbb", "ccc", "ddddddddddddd");

		for(String w : words) {
			new Thread(() -> {
				if (w.length() > 12) {
					count++;
				}
			}).start();
		}
		System.out.println("Count : " + count);
	}
}
