package js8ri.ch08.ex04;

import java.util.OptionalLong;
import java.util.stream.LongStream;

public class Random {

	public static long prev(long s) {
		long a = 11L;
		long V = 246154705703781L;
		long N = 1L << 48;
		return (s - a) * V % N;
	}

	public static void main(String[] args) {
		long M = 25214903917L;

		OptionalLong seed = LongStream.iterate(prev(0), s -> prev(prev(0)))
				.map(s -> s ^ M)
				.limit(1000000)
				.min();
		System.out.println("Seed: " + seed.getAsLong()); // ??
	}

}
