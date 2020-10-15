package js8ri.CH02.ex05;

import java.util.stream.Stream;

public class RandomStream {
	public static Stream<Long> generate(long a, int c, long m, long seed){
		return Stream.iterate(seed, x -> (((long) a * x + c) %  (long) m));
	}

	public static void main(String[] args) {
		long a = 25214903917L;
		int c = 11;
		long m = (long) Math.pow(2, 48);
		long seed = 10;
		Stream<Long> longStream = generate(a, c, m, seed);
		longStream.limit(10).forEach(System.out::println);
	}
}
