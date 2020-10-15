package js8ri.CH02.ex13;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCountUseCollect {
	public static void main(String[] args) {
		Map<Integer, Long> shortWords = Stream.of("aaa", "bbbb", "ccccc", "dddddd")
                .parallel().filter(s -> s.length() < 12)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
		shortWords.entrySet().forEach(System.out::println);
	}
}
