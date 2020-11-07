package js8ri.ch03.ex18;

import java.util.function.Function;

public class UncheckedFunc {
	public interface ThrowFunc<T, U> {
		public U apply(T t) throws Exception;
	}

	public static <T, U> Function<T, U> unchecked(ThrowFunc<T, U> f) {
		return t -> {
			try {
				return f.apply(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} catch (Throwable thr) {
				throw thr;
			}
		};
	}
}
