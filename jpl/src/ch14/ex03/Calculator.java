package jpl.ch14.ex03;

public class Calculator {
	private int sum;

	public Calculator() {
		this.sum = 0;
	}
	public synchronized void add() {
		sum++;
		System.out.println(Thread.currentThread().getName() + ": " + sum);
	}
}
