package js8ri.ch08.ex01;

public class Calc {
	// 「%」や「/」 だと計算結果が違うため、divideUnsigned や remainderUnsigned が必要

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		System.out.println("Integer MAX       : " + Integer.MAX_VALUE);
		System.out.println("Add               : " + (a + a));
		System.out.println("Add(with unsigned): " + Integer.toUnsignedString(a + a));

		int b = Integer.MAX_VALUE + 2;
		System.out.println("Sub               : " + (b - 1));
		System.out.println("Sub(with unsigned): " + Integer.toUnsignedString(b - 1));

		System.out.println("Div               : " + (b / 2)  + " ... " + (b % 2));
		System.out.println("Div(with unsigned): " + Integer.divideUnsigned(b, 2) + " ... " + Integer.remainderUnsigned(b, 2));
	}

}
