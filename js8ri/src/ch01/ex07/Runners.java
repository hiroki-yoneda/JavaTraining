package js8ri.ch01.ex07;

public class Runners {
	public static Runnable andThen(Runnable first, Runnable second) {
		return () -> {
			first.run();
			second.run();
		};
	}

	public static void main(final String[] args) {
        andThen(() -> System.out.println("zZZ"), () -> System.out.println(".oO")).run();
    }
}
