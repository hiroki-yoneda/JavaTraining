package jpl.ch14.ex05;

public class Calculator {
	private static int sum = 0;

	public static synchronized void add() {
		sum++;
		System.out.println(Thread.currentThread().getName() + ": " + sum);
	}

	public static void minus() {
		synchronized(Calculator.class) {
			sum--;
			System.out.println(Thread.currentThread().getName() + ": " + sum);
		}

	}
}
