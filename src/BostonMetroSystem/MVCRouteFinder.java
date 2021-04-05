package BostonMetroSystem;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * Used as the driver classes to run the entire application
 */
public class MVCRouteFinder extends Application {
    Stage window;
    Scene scene;

    private RouteFinderController theController;

    public static void main(String[] args){
        launch(args);
    }

    /**
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        theController = new RouteFinderController();

        window = stage;
        window.setTitle("Route Finder - Boston Metro System");

        scene = new Scene(theController.getParent(), 700, 500);
        window.setScene(scene);
        window.show();
    }
}
