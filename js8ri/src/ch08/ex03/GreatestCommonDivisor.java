package js8ri.ch08.ex03;

public class GreatestCommonDivisor {

	public static int gcd01(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
	    while (a != 0 && b != 0) {
	        if (a >= b) {
	            a %= b;
	        } else {
	            b %= a;
	        }
	    }
	    return a == 0 ? b: a;
	}

	public static int gcd02(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
	    while (a != 0 && b != 0) {
	        if (a >= b) {
	        	a = Math.floorMod(a, b);
	        } else {
	            b = Math.floorMod(b, a);
	        }
	    }
	    return a == 0 ? b: a;
	}

	public static int gcd03(int a, int b) {
		// 数学的な？
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(gcd01(42, 30));
		System.out.println(gcd01(0, 30));
		System.out.println(gcd01(42, 0));
		System.out.println(gcd02(42, 30));
		System.out.println(gcd02(0, 30));
		System.out.println(gcd02(42, 0));
	}
}
