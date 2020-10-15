package js8ri.CH02.ex09;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MergeArray {
	// 3つ？
	public static <T> ArrayList<T> reduceArrays(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<T>(), (sa1, sa2) -> {
            sa1.addAll(sa2);
            return sa1;
        }, (sa1, sa3) -> {
            sa1.addAll(sa3);
            return sa1;
        });
    }

	public static void main (String[] args) {
		ArrayList<String> list1 = new ArrayList<String>() {{
		       add("a");
		       add("b");
		       add("c");
		}};
		ArrayList<String> list2 = new ArrayList<String>() {{
		       add("A");
		       add("B");
		       add("C");
		}};
		ArrayList<String> list3 = new ArrayList<String>() {{
		       add("1");
		       add("2");
		       add("3");
		}};
		reduceArrays(Stream.of(list1, list2, list3)).forEach(System.out::println);
	}
}
