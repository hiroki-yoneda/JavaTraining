package jpl.ch01.ex04;

public class Practice0104 {

	public static void main(String[] args) {
		int result = 1;
		int tolerance = 4;
		System.out.println("値が50未満になるまでの等差数列を表示する");
		while(result < 50) {
			System.out.println(result);
			result = result + tolerance;
			}
	}
}
