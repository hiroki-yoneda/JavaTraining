package js8ri.ch04.ex02;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class FXProperty<T> {
	private ObjectProperty<T> obj;

	public final ObjectProperty<T> objProperty() {
		obj = new SimpleObjectProperty<T>();
		return obj;
	}

	public final void setObj(T value) {
		obj.set(value);
	}

	public final T getObj() {
		return obj.get();
	}
}
