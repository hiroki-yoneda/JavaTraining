package jpl.ch14.ex04;

public class Calculator {
	private static int sum = 0;

	public static synchronized void add() {
		sum++;
		System.out.println(Thread.currentThread().getName() + ": " + sum);
	}
}
