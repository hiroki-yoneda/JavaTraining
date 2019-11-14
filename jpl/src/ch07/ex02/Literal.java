package jpl.ch07.ex02;

public class Literal {

	public static void main(String[] args) {
		// boolean bo = 0; // int型へ変換を推奨される
		char ch = 0006;
		System.out.println(ch); // 「Ӓ」が表示される。なぜ？
		byte by = 'a';
		System.out.println(by); // 「97」が表示される ASCII
		short sh = 'a';
		System.out.println(sh); // 「97」が表示される
		// int in = 3.5f; // int にキャストを推奨される
		// long lo = 10.1l;
		// float fl = 4.0;
		// double dou = 4.0l;
	}

}
