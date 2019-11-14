package jpl.ch09.ex03;

public class PascalOperation {
	private final static int Depth = 12;

	public static void main(String[] args) {
		Pascal p = new Pascal(Depth);
		p.calc();
		p.print();
	}
}
