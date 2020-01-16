package jpl.ch14.ex01;

public class PrintThreadName {
	public static void main(String[] args) {
		System.out.println("main: " + Thread.currentThread().getName());
	}
}
