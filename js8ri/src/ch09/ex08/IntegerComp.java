package js8ri.ch09.ex08;

import java.awt.Point;

public class IntegerComp {
	int x = 5;
	int y = 5;

	public int compareTo(Point other) {
		int diff = Integer.compare(x, other.x);
		if (diff != 0)
			return diff;
		return Integer.compare(y, other.y);
	}

	public static void main(String[] args) {
		IntegerComp intComp = new IntegerComp();
		System.out.println(intComp.compareTo(new Point(10, 10)));
		System.out.println(intComp.compareTo(new Point(5, 5)));
	}
}
