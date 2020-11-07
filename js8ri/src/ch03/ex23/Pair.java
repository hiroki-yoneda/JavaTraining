package js8ri.ch03.ex23;

import java.util.function.Function;

public class Pair<T> {
	// T 型の対となる２つのオブジェクト？
	final T value1;
	final T value2;

	public Pair(T value1, T value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	public <U> Pair<U> map(Function<T, U> f) {
		return new Pair<U>(f.apply(this.value1), f.apply(this.value2));
	}

	public <U> Pair<U> flatmap(Function<? super T, ? extends Pair<U>> f){
		// わからない。できない？
		return null;
	}
}
