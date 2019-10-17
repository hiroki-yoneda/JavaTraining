package jpl.ch01.ex13;

public class Practice0113 {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.printf(1 + ":  %.2f %n", (float) hi);
		for(int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			System.out.printf(i + ":  %.2f" + mark + "%n", (float) hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
