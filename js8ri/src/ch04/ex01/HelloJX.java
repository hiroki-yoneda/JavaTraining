package js8ri.ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJX extends Application {

	public void start(Stage stage) throws Exception {
		final String msg = "Hello, FX";
		Label label = new Label(msg);
		label.setFont(new Font(100));
		TextField textField = new TextField(msg);

		label.textProperty().bind(textField.textProperty());

		BorderPane pane = new BorderPane();
		pane.setTop(label);
		pane.setCenter(textField);

	    stage.setTitle(msg);
	    stage.setScene(new Scene(pane));
	    stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
