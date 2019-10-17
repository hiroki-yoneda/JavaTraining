package jpl.ch01.ex10;

public class SaveFibonacciArray {

	public int[] fibonacciArray;
	public boolean[] isEven;

	public SaveFibonacciArray(int arraySize) {
		fibonacciArray = new int[arraySize];
		isEven = new boolean[arraySize];
	}

	public void setFibonacci(int num, int ele) {
		this.fibonacciArray[ele] = num;
	}

	public void isEven(boolean isEven, int ele) {
		this.isEven[ele] = isEven;
	}
}
