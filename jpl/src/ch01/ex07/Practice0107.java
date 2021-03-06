package jpl.ch01.ex07;

public class Practice0107 {

	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.println("1: " + lo);
		for (int i = MAX_INDEX; i >= 2; i--) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
