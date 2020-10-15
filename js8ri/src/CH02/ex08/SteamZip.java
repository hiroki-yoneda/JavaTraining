package js8ri.CH02.ex08;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamZip {
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
		List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        int times = Math.min(firstList.size(), secondList.size());
        Stream.Builder<T> builder = Stream.builder();
        IntStream.range(0, times).forEach(i -> {
        	builder.add(firstList.get(i));
            builder.add(secondList.get(i));
        });
		return builder.build();
	}

	public static void main(String[] args) {
		Stream<String> first = Stream.of("a", "b", "c", "d");
		Stream<String> second = Stream.of("1", "2", "3");
		zip(first, second).forEach(System.out::println);
	}
}
