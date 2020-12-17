package js8ri.ch06.ex04;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAccumulator;

public class CulcMaxAndMin {

	static long max(long[] longs) {
		LongAccumulator longAccumulator = new LongAccumulator(Long::max, 0);
		Arrays.stream(longs).parallel().forEach(longAccumulator::accumulate);
		return longAccumulator.get();
	}

	static long min(long[] longs) {
		LongAccumulator longAccumulator = new LongAccumulator(Long::min, 0);
		Arrays.stream(longs).parallel().forEach(longAccumulator::accumulate);
		return longAccumulator.get();
	}

	public static void main(String[] args) {
		long[] longs = {0, 1, -1, -10, 100, 10, -100};
		System.out.println("Max: " + max(longs));
		System.out.println("Min: " + min(longs));
	}
}
