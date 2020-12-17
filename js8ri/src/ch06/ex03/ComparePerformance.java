package js8ri.ch06.ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class ComparePerformance {

	static final int THREAD_NUM = 1000;
	static final int INCREMENT_TIMES = 100000;

	static void countAtomicLong() {
		AtomicLong atomicLong = new AtomicLong();
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<INCREMENT_TIMES; i++) {
			pool.submit(() -> {
				atomicLong.incrementAndGet();
			});
		}
		long endTime = System.currentTimeMillis();
		System.out.println("AtomicLong: " + (endTime - startTime) + " ms");
		pool.shutdown();
	}

	static void countLongAdder() {
		LongAdder longAdder = new LongAdder();
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<INCREMENT_TIMES; i++) {
			pool.submit(() -> {
				longAdder.increment();;
			});
		}
		long endTime = System.currentTimeMillis();
		System.out.println("LongAdder: " + (endTime - startTime) + " ms");
		pool.shutdown();
	}

	public static void main(String[] args) {
		countAtomicLong();
		countLongAdder();
	}
}
