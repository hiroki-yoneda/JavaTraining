package jpl.ch17.ex01;

import java.util.ArrayList;
import java.util.List;

public class CheckMemory {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long isFree = rt.freeMemory();
		long wasFree;
		// 最初のメモリチェック
		System.out.println(isFree);

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			list.add(new String("test"));
		}
		// オブジェクト生成後のメモリチェック
		System.out.println(isFree);

		do {
			wasFree = isFree;
			rt.runFinalization();
			rt.gc();
			isFree = rt.freeMemory();
		} while (isFree > wasFree);
		// GC 後のメモリチェック
		System.out.println(isFree);
	}
}
