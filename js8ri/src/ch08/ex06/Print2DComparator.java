package js8ri.ch08.ex06;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;

public class Print2DComparator {

	public static void main(String[] args) {
		Comparator<Point2D> compPoint = Comparator.comparing(Point2D::getX)
				.thenComparing(Point2D::getY);
		Point2D[] arrayP = {new Point(2, 3), new Point(0, 0), new Point(1, 1)};
		Arrays.sort(arrayP, compPoint);
		Arrays.stream(arrayP).forEach(System.out::println);

		Comparator<Rectangle2D> compRect = Comparator.comparing(Rectangle2D::getMinX)
				.thenComparing(Rectangle2D::getMinY)
				.thenComparing(Rectangle2D::getMaxX)
				.thenComparing(Rectangle2D::getMaxY);
		Rectangle2D[] arrayR = {
				new Rectangle2D.Double(5, 5, 3, 3),
				new Rectangle2D.Double(1, 1, 1, 1),
				new Rectangle2D.Double(2, 2, 2, 2)
		};
		Arrays.sort(arrayR, compRect);
		Arrays.stream(arrayR).forEach(System.out::println);
	}

}
