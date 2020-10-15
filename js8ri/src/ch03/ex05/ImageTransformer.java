package js8ri.ch03.ex05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

	public static Image fillFrame(Image input) {
        return transform(input, (x, y, color) -> {
            int height = (int) input.getHeight();
            if (x <= 10 || x >= height - 10 || y <= 10 || y >= height - 10) {
                return Color.gray(0.5);
            }
            return input.getPixelReader().getColor(x, y);
        });
    }

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		File f = new File("src/main/java/js8ri/ch03/ex05/line.png");
		Image img = null;
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			img = new Image(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Image out = fillFrame(img);

		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 320, 240);
		//Paneの中心に配置
		pane.setAlignment(Pos.CENTER);
		//imageviewの作成
		ImageView imgView = new ImageView(out);
		//Paneにimageviewを載せる
		pane.getChildren().add( imgView );
		stage.setScene(scene);
		stage.show();
	}
}
