package js8ri.ch08.ex02;

public class MathNegate {
	// Exception in thread "main" java.lang.ArithmeticException: integer overflow
	//  at java.base/java.lang.Math.negateExact(Math.java:1036)
	//  at js8ri.ch08.ex02.MathNegate.main(MathNegate.java:7)
	public static void main(String[] args) {
		int n = Integer.MIN_VALUE;
	    Math.negateExact(n);
	}

}
