package js8ri.ch03.ex06;

import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ImageTransform {
	// BiFunction https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/BiFunction.html
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int height = (int) in.getHeight();
        int width = (int) in.getWidth();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
            }
        }
        return out;
	}
}
