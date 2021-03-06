package application;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;
import java.util.prefs.Preferences;
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
	private final Preferences prefs = Preferences.userNodeForPackage(this.getClass());
	private Property props;
	private Stage stage;

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		this.props = new Property();

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		MenuItem propertyMenu = new MenuItem("Property");
		propertyMenu.setOnAction(e -> {
			Main.showDialog(props);
		});
		menu.getItems().addAll(propertyMenu);
		menuBar.getMenus().addAll(menu);

		Text time = new Text();

		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				time.setText(Calendar.getInstance().getTime().toString());
				time.setFont(new Font(props.getFont(), props.getFontSize()));
				time.setFill(Color.valueOf(props.getFontColor()));
				primaryStage.setWidth(time.getLayoutBounds().getWidth() + 20);
				primaryStage.setHeight(time.getLayoutBounds().getHeight() + menuBar.getLayoutBounds().getHeight() + 20);
				root.setBackground(new Background(new BackgroundFill(Color.valueOf(props.getBackgroundColor()), null, null)));
				stage = primaryStage;
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
		loadPref(primaryStage, props);

		timer.play();
	}

	public void loadPref(Stage primaStage, Property props) {
		String font = prefs.get("font", this.props.getFont());
		int font_size = prefs.getInt("font_size", this.props.getFontSize());
		String clock_color = prefs.get("clock_color", this.props.getFontColor());
		String back_color = prefs.get("back_color", this.props.getBackgroundColor());

		this.props.setFont(font);
		this.props.setFontSize(font_size);
		this.props.setFontColor(clock_color);
		this.props.setBackgroundColor(back_color);

		double window_top = prefs.getDouble("window_top", 100);
		double window_left = prefs.getDouble("window_left", 100);
		System.out.println(window_top);
		System.out.println(window_left);
		primaStage.setX(window_top);
		primaStage.setY(window_left);
	}

	@Override
	public void stop() {
		prefs.put("font", this.props.getFont());
		prefs.putInt("font_size", this.props.getFontSize());
		prefs.put("clock_color", this.props.getFontColor());
		prefs.put("back_color", this.props.getBackgroundColor());
		prefs.putDouble("window_top", stage.getX());
		prefs.putDouble("window_left", stage.getY());
		System.out.println(stage.getX());
		System.out.println(stage.getY());
		System.out.println("Closed!!!!");
	}

	public static void showDialog(Property props) {
		Dialog<String> dialog = new Dialog<>();
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

		// Define dialog select box //////////////////////////////////////////////////////
	    GridPane grid = new GridPane();
	    ComboBox<String> cmbBoxFont = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.FONTS).map(Object::toString).collect(Collectors.toList())
	    		));
	    cmbBoxFont.setValue(props.getFont());
	    grid.add(new Label("Font: "), 0, 0);
	    grid.add(cmbBoxFont, 1, 0);
	    GridPane.setHalignment(cmbBoxFont, HPos.RIGHT);

	    ComboBox<String> cmbBoxFontSize = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.FONT_SIZE).mapToObj(Integer::toString).collect(Collectors.toList())
	    		));
	    cmbBoxFontSize.setValue(Integer.toString(props.getFontSize()));
	    grid.add(new Label("Font size: "), 0, 1);
	    grid.add(cmbBoxFontSize, 1, 1);
	    GridPane.setHalignment(cmbBoxFontSize, HPos.RIGHT);

	    ComboBox<String> cmbBoxBackColor = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.STRING_COLOR).collect(Collectors.toList())
	    		));
	    cmbBoxBackColor.setValue(props.getBackgroundColor());
	    grid.add(new Label("Background color: "), 0, 2);
	    grid.add(cmbBoxBackColor, 1, 2);
	    GridPane.setHalignment(cmbBoxBackColor, HPos.RIGHT);

	    ComboBox<String> cmbBoxFontColor = new ComboBox<>(FXCollections.observableArrayList(
	    		Arrays.stream(Property.STRING_COLOR).collect(Collectors.toList())
	    		));
	    cmbBoxFontColor.setValue(props.getFontColor());
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
	    	props.setFont(cmbBoxFont.getValue());
	    	props.setFontSize(Integer.parseInt(cmbBoxFontSize.getValue()));
	    	props.setBackgroundColor(cmbBoxBackColor.getValue());
	    	props.setFontColor(cmbBoxFontColor.getValue());
	    };
	}

	public static void main(String[] args) {
		launch(args);
	}
}
