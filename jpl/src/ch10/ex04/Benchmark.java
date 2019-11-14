package jpl.ch10.ex04;

abstract class Benchmark {
	abstract void benchmark();

	public final long repeat(int count) {
		long start = System.nanoTime();
		int i = 0;
		while(i < count) {
			benchmark();
			i++;
		}
		return (System.nanoTime() - start);
	}
}
