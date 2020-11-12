package js8ri.ch04.ex05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;

public class Observales {
	static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
        return new FuncObservableValue<>(f, t);
    }

    static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
        return new BiFuncObservableValue<>(f, t, u);
    }

    static class FuncObservableValue<T, R> extends ObservableValueBase<R> {
        final ObservableValue<T> observableValue;
        final Function<T, R> function;

        FuncObservableValue(Function<T, R> f, ObservableValue<T> t) {
            observableValue = t;
            function = f;
            observableValue.addListener(observables -> fireValueChangedEvent());
            observableValue.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
        }

        @Override
        public R getValue() {
            return function.apply(observableValue.getValue());
        }
    }

    static class BiFuncObservableValue<T, U, R> extends ObservableValueBase<R> {
        final ObservableValue<T> observableValueT;
        final ObservableValue<U> observableValueU;
        final BiFunction<T, U, R> biFunc;

        BiFuncObservableValue(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
            observableValueT = t;
            observableValueU = u;
            biFunc = f;
            observableValueT.addListener(observables -> fireValueChangedEvent());
            observableValueT.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
            observableValueU.addListener(observables -> fireValueChangedEvent());
            observableValueU.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
        }

        @Override
        public R getValue() {
            return biFunc.apply(observableValueT.getValue(), observableValueU.getValue());
        }
    }
}
