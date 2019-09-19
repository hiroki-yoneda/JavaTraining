package practice01;

public class Practice0112 {

	static final int MAX_INDEX = 9;
	static final String[] array = new String[MAX_INDEX];

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		array[0] = 1 + ": " + hi;
		System.out.println(array[0]);
		for (int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			array[i - 1] = i + ": " + hi + mark;
			System.out.println(array[i - 1]);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
