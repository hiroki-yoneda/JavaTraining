package js8ri.CH02.ex02;

import java.util.stream.Stream;

public class StringFilter {
	public static void main(final String[] args) {
		Stream.of("aaaaaa", "bbbbbbb", "cccccc", "dddddd", "eeeeee", "ffffff", "gggggg")
        .filter(s -> {
            System.out.println(s);
            return s.length() > 5;
        })
        .limit(5)
        .forEach(System.out::println);
	}
}
