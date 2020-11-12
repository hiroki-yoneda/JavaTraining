package js8ri.ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleFX extends Application {
	@Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle();
        Scene scene = new Scene(new Pane(circle));
        circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
        circle.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2));
        circle.radiusProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).divide(2));
        stage.setScene(scene);
        stage.show();
    }

	public static void main(String[] args) {
		Application.launch(args);
	}
}
