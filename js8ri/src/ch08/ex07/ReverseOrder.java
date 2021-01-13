package js8ri.ch08.ex07;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseOrder {

	public static void main(String[] args) {
		String[] arrStr = {"a", null, "e", "c", "b", null, "d"};
		Comparator<String> comp = Comparator.nullsFirst(Comparator.reverseOrder());
		Arrays.sort(arrStr, comp);
		Arrays.stream(arrStr).forEach(System.out::println);
	}

}
