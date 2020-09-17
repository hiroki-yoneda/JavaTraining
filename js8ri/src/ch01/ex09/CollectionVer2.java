package js8ri.ch01.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Collection2<T> extends Collection<T> {
	// https://qiita.com/opengl-8080/items/22c4405a38127ed86a31
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        stream().filter(filter::test).forEach(action);
    }
}
