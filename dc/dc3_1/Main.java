package application;

import java.util.Calendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();

		Text time = new Text();
		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				time.setText(Calendar.getInstance().getTime().toString());
	        }
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		root.setTop(time);
		Scene scene = new Scene(root, 200, 30);
		primaryStage.setScene(scene);
		primaryStage.setWidth(time.getLayoutBounds().getWidth());
		primaryStage.show();
		timer.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
