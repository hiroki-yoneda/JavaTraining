package js8ri.ch03.ex11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageTransformer extends Application{
	public interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);

        static ColorTransformer SyntheColorTransformer(ColorTransformer ct1, ColorTransformer ct2) {
        	return (x, y, c) -> ct2.apply(x, y, ct1.apply(x, y, c));
        }

        static ColorTransformer toColorTransformer(UnaryOperator<Color> operator) {
        	return (x, y, c) -> operator.apply(c);
        }
    }

	public static Image transform(Image in, ColorTransformer transformer) {
        int height = (int) in.getHeight();
        int width = (int) in.getWidth();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, transformer.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

	public static ColorTransformer fillFrame(Image input, int frame_size, Color color) {
        return (x, y, c) -> {
            int height = (int) input.getHeight();
            if (x <= frame_size || x >= height - frame_size || y <= frame_size || y >= height - frame_size) {
                return color;
            }
            return input.getPixelReader().getColor(x, y);
        };
    }

	public void start(Stage stage) throws Exception {
		Integer frame_size = 30;
		Color color = Color.AQUA;
		File f = new File("src/main/java/js8ri/ch03/ex11/line.png");
		Image img = null;
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			img = new Image(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ColorTransformer colorBrighter = ColorTransformer.toColorTransformer(Color::brighter);
		ColorTransformer fillFramer = fillFrame(img, frame_size, color);
		ColorTransformer comb = ColorTransformer.SyntheColorTransformer(colorBrighter, fillFramer);

		Image out = transform(img, comb);

		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 320, 240);
		//Paneの中心に配置
		pane.setAlignment(Pos.CENTER);
		//imageviewの作成
		ImageView imgView = new ImageView(out);
		//Paneにimageviewを載せる
		pane.getChildren().add(imgView);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
