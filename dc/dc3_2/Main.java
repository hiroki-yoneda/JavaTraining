package application;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;
import java.util.stream.Collectors;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		MenuItem propertyMenu = new MenuItem("Property");
		propertyMenu.setOnAction(e -> {
			Main.showDialog();
		});
		menu.getItems().addAll(propertyMenu);
		menuBar.getMenus().addAll(menu);

		Text time = new Text();

		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				time.setText(Calendar.getInstance().getTime().toString());
				time.setFont(new Font(Property.getFont(), Property.getFontSize()));
				time.setFill(Color.valueOf(Property.getFontColor()));
				primaryStage.setWidth(time.getLayoutBounds().getWidth() + 20);
				primaryStage.setHeight(time.getLayoutBounds().getHeight() + menuBar.getLayoutBounds().getHeight() + 20);
				root.setBackground(new Background(new BackgroundFill(Color.valueOf(Property.getBackgroundColor()), null, null)));

	        }
		}));
		timer.setCycleCount(Timeline.INDEFINITE);

		root.setTop(menuBar);
		root.setCenter(time);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setWidth(time.getLayoutBounds().getWidth());
		primaryStage.setHeight(time.getLayoutBounds().getHeight() + menuBar.getLayoutBounds().getHeight() + 10);
		primaryStage.show();
		timer.play();
	}

	public static class Property {
		public final static String FONTS[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		public static final int FONT_SIZE[] = {30, 60, 90};
		public static final String STRING_COLOR[] = { "Black", "White", "Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "Orange" };

		private static String font = "Apple Chancery";
		private static int font_size = 30;
		private static String backGroundColor = "White";
		private static String fontColor = "Black";

		public static void setFont(String font) {Property.font = font;}
		public static String getFont() {return Property.font;}
		public static void setFontSize(int font_size) {Property.font_size = font_size;}
		public static int getFontSize() {return font_size;}
		public static void setBackgroundColor(String color) {Property.backGroundColor = color;}
		public static String getBackgroundColor() {return Property.backGroundColor;}
		public static void setFontColor(String color) {Property.fontColor = color;}
		public static String getFontColor() {return Property.fontColor;}
	}

	public static void showDialog() {
		Dialog<String> dialog = new Dialog<>();
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

		// Define dialog select box //////////////////////////////////////////////////////
	    GridPane grid = new GridPane();
	    ComboBox<String> cmbBoxFont = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.FONTS).map(Object::toString).collect(Collectors.toList())
	    		));
	    cmbBoxFont.setValue(Property.getFont());
	    grid.add(new Label("Font: "), 0, 0);
	    grid.add(cmbBoxFont, 1, 0);
	    GridPane.setHalignment(cmbBoxFont, HPos.RIGHT);

	    ComboBox<String> cmbBoxFontSize = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.FONT_SIZE).mapToObj(Integer::toString).collect(Collectors.toList())
	    		));
	    cmbBoxFontSize.setValue(Integer.toString(Property.getFontSize()));
	    grid.add(new Label("Font size: "), 0, 1);
	    grid.add(cmbBoxFontSize, 1, 1);
	    GridPane.setHalignment(cmbBoxFontSize, HPos.RIGHT);

	    ComboBox<String> cmbBoxBackColor = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.STRING_COLOR).collect(Collectors.toList())
	    		));
	    cmbBoxBackColor.setValue(Property.getBackgroundColor());
	    grid.add(new Label("Background color: "), 0, 2);
	    grid.add(cmbBoxBackColor, 1, 2);
	    GridPane.setHalignment(cmbBoxBackColor, HPos.RIGHT);

	    ComboBox<String> cmbBoxFontColor = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.STRING_COLOR).collect(Collectors.toList())
	    		));
	    cmbBoxFontColor.setValue(Property.getFontColor());
	    grid.add(new Label("Font color: "), 0, 3);
	    grid.add(cmbBoxFontColor, 1, 3);
	    GridPane.setHalignment(cmbBoxFontColor, HPos.RIGHT);

	    dialog.getDialogPane().setContent(grid);
	    /////////////////////////////////////////////////////////////////////////////////////

	    dialog.setResultConverter(ButtonType::getText);
	    dialog.setTitle("title");
	    // https://stackoverflow.com/questions/52342915/javafx-dialog-getresult-method-not-returning-the-right-generic-type
	    String result = dialog.showAndWait().orElse(null);
	    if(Objects.equals(result, "OK")) {
	    	Property.setFont(cmbBoxFont.getValue());
	    	Property.setFontSize(Integer.parseInt(cmbBoxFontSize.getValue()));
	    	Property.setBackgroundColor(cmbBoxBackColor.getValue());
	    	Property.setFontColor(cmbBoxFontColor.getValue());
	    };
	}

	public static void main(String[] args) {
		launch(args);
	}
}
