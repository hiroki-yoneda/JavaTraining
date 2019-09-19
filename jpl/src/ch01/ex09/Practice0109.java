package practice01;

import java.util.Arrays;

public class Practice0109 {

	public static final int MAX_INDEX = 10;
	public static int[] array = new int[MAX_INDEX];

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println(lo);
		for (int i = 0; i < MAX_INDEX; i++) {
			System.out.println(hi);
			array[i] = hi;
			hi = lo + hi;
			lo = hi - lo;
		}
		System.out.println(Arrays.toString(array));
	}
}
