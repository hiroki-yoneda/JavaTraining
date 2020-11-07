package js8ri.ch03.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import js8ri.ch03.ex12.ImageTransformer.ColorTransformer;

public class LatentImage {
	private final Image in;
	private final List<ColorTransformer> pendingOperations = new ArrayList<>();

	private LatentImage (Image in) {
		this.in = in;
	}

	public static LatentImage from (Image image) {
		return new LatentImage(image);
	}

	public LatentImage transform (ColorTransformer f) {
		pendingOperations.add(f);
		return this;
	}

	public LatentImage transform (UnaryOperator<Color> f) {
		return transform(toColorTransformer(f));
	}

	private ColorTransformer toColorTransformer(UnaryOperator<Color> operator) {
		return (x, y, c)-> operator.apply(c);
	}

	public Image toImage () {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (ColorTransformer f: pendingOperations) {
						c = f.apply(x, y, c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}
}
