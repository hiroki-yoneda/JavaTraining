package jpl.ch10.ex04;

public class Loop extends Benchmark {
	private final static int count = 1;
	private final int loopTimes = 1000;

	void benchmark() {
		int i = 0;
		while (i < loopTimes)
			i++;
	}

	public static void main(String[] args) {
		long time = new Loop().repeat(count);
		System.out.println(count + " method in " + time + " nanoseconds");
	}

}
