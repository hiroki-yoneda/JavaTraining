package js8ri.ch03.ex17;

import java.util.function.Consumer;

public class ParallelDoInOrder {
	public static <T> void doInOrderAsync(Runnable first, Runnable second, Consumer<Throwable> handler){
		Thread t1 = new Thread() {
			public void run() {
				try {
					first.run();
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				try {
					second.run();
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t1.start();
		t2.start();
	}
}
