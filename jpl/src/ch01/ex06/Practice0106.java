package practice01;

public class Practice0106 {

	public static void main(String[] args) {
		final String title = "値が50未満のフィボナッチ数列を表示する";
		int lo = 1;
		int hi = 1;
		System.out.println(title);
		System.out.println(lo);
		while(hi < 50) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
