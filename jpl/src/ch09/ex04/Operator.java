package jpl.ch09.ex04;

public class Operator {

	public static void main(String[] args) {
		int a = 3 << 2L -1;
		System.out.println(a);

		long b = (3L << 2) -1;
		System.out.println(b);

		boolean c = 10< 12 == 6 > 17;
		System.out.println(c);

		boolean d = 10 << 12 == 6 >>17;
		System.out.println(d);

		double e = 13.5e-1 % Float.POSITIVE_INFINITY;
		System.out.println(e);

		double f = Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY;
		System.out.println(f);

		double g = 0.0 / (-0.0);
		double h = -0.0 / 0.0;
		if(g == h)
			System.out.println("e==f");
		System.out.println(g);
		System.out.println(h);

		int i = Integer.MAX_VALUE + Integer.MIN_VALUE;
		System.out.println(i);

		long j = Long.MAX_VALUE + 5;
		System.out.println(j);

		byte k = (short) 5 * (byte) 10;
		System.out.println(k);

		double l  = (k < 15? 1.72e3f : 0);
		System.out.println(l);

		int m = 3;
		System.out.println(m++ + m++ + --m);
	}

}
