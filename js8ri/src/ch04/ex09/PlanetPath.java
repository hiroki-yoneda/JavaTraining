package js8ri.ch04.ex09;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetPath extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
        Circle planet = new Circle(100, 20, 20);
        planet.setRadius(20);
        Scene scene = new Scene(new Pane(planet));
        Ellipse ellipse = new Ellipse(130, 70, 100, 50);
        PathTransition ellipseTransition = new PathTransition(Duration.millis(5000), ellipse, planet);
        ellipseTransition.setInterpolator(Interpolator.LINEAR);
        ellipseTransition.setCycleCount(Animation.INDEFINITE);
        primaryStage.setScene(scene);
        primaryStage.setHeight(200);
        primaryStage.setWidth(280);
        primaryStage.setTitle("Planet");
        primaryStage.show();
        ellipseTransition.play();
    }
}
