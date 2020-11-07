package js8ri.ch03.ex12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageTransformer extends Application{
	public interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);
    }

	public static ColorTransformer fillFrame(Image input) {
        return (x, y, c) -> {
            int height = (int) input.getHeight();
            if (x <= 10 || x >= height - 10 || y <= 10 || y >= height - 10) {
                return Color.gray(0.5);
            }
            return input.getPixelReader().getColor(x, y);
        };
    }

	@Override
	public void start(Stage stage) throws Exception {
		File f = new File("src/main/java/js8ri/ch03/ex12/line.png");
		Image img = null;
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			img = new Image(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ColorTransformer fillFramer = fillFrame(img);
		Image out = LatentImage.from(img).transform(Color::brighter).transform(fillFramer).toImage();


		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 320, 240);
		pane.setAlignment(Pos.CENTER);
		ImageView imgView = new ImageView(out);
		pane.getChildren().add(imgView);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
