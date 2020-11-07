package js8ri.ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorGenerator {
	public static Comparator<String> compInOrder(){
		return (s1, s2) -> s1.compareTo(s2);
	}

	public static Comparator<String> compReverse(){
		return (s1, s2) -> s2.compareTo(s1);
	}

	public static Comparator<String> compIgnoreCase(){
		return (s1, s2) -> s1.compareToIgnoreCase(s2);
	}

	public static Comparator<String> compIgnoreSpace(){
		return (s1, s2) -> s1.trim().compareToIgnoreCase(s2.trim());
	}

	public static void main(String[] args) {
		String[] strings = {"a", "D", "c", "e", "B", "F", " g", "H"};

		Comparator<String> inOrder = compInOrder();
		Arrays.sort(strings, inOrder);
		System.out.println(Arrays.toString(strings));

		Comparator<String> reverse = compReverse();
		Arrays.sort(strings, reverse);
		System.out.println(Arrays.toString(strings));

		Comparator<String> ignoreCase = compIgnoreCase();
		Arrays.sort(strings, ignoreCase);
		System.out.println(Arrays.toString(strings));

		Comparator<String> ignoreSpace = compIgnoreSpace();
		Arrays.sort(strings, ignoreSpace);
		System.out.println(Arrays.toString(strings));
	}
}
