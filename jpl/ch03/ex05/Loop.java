package jpl.ch03.ex05;

public class Loop extends Benchmark{
	private final static int count = 1;
	private final int loopTimes = 1000;

	void benchmark() {
		for (int i = 0; i < loopTimes; i++) {
		}
	}

	public static void main(String[] args) {
		long time = new Loop().repeat(count);
		System.out.println(count + " method in " + time + " nanoseconds");
	}

}
