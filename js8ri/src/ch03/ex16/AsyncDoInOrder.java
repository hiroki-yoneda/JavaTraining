package js8ri.ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

// ３つ目のパラメーターの必要性を感じなかったので、必要ない。
public class AsyncDoInOrder {
	//BiConsumer: https://www.atmarkit.co.jp/ait/articles/1404/30/news017.html
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second){
		Thread t = new Thread() {
			public void run() {
				try {
					T result = first.get();
					second.accept(result, null);
				} catch (Throwable t) {
					second.accept(null, t);
				}
			}
		};
		t.start();
	}
}
