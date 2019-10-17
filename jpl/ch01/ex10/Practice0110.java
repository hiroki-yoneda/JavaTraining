package jpl.ch01.ex10;

import java.util.Arrays;

public class Practice0110 {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		SaveFibonacciArray saveFibonacciArray = new SaveFibonacciArray(MAX_INDEX);

		System.out.println("1: " + lo);
		saveFibonacciArray.setFibonacci(hi, 0);
		saveFibonacciArray.isEven(lo % 2 == 0, 0);
		for (int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0) {
				saveFibonacciArray.isEven(true, i - 1);
				mark = " *";
			} else {
				saveFibonacciArray.isEven(false, i - 1);
				mark = "";
			}
			saveFibonacciArray.setFibonacci(hi, i - 1);
			System.out.println(i + ": " + hi + mark);
			hi = lo + hi;
			lo = hi - lo;
		}
		System.out.println(Arrays.toString(saveFibonacciArray.fibonacciArray));
		System.out.println(Arrays.toString(saveFibonacciArray.isEven));
	}
}
