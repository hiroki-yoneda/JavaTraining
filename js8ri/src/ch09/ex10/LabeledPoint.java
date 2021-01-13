package js8ri.ch09.ex10;

import java.util.Objects;

public class LabeledPoint {
	private String label;
	private int x;
	private int y;

	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}
		if (getClass() != otherObject.getClass()) {
			return false;
		}
		LabeledPoint other = (LabeledPoint) otherObject;
		return Objects.equals(x, other.x) && Objects.equals(y, other.y) && Objects.equals(label, other.label);
	}

	public int hashCode() {
		return Objects.hash(label, x, y);
	}

	public int compareTo(LabeledPoint other) {
		int diff = Integer.compare(x, other.x);
		if (diff != 0) {
			return diff;
		}
		return Integer.compare(y, other.y);
	}
}
