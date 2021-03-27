package BostonMetroSystem;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MVCRouteFinder extends Application {
    Stage window;
    Scene scene;

    private RouteFinderModel theModel;
    private RouteFinderController theController;
    private RouteFinderView theView;

    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        theModel = new RouteFinderModel();
        theController = new RouteFinderController(theModel);
        theView = new RouteFinderView(theController, theModel);

        window = stage;
        window.setTitle("Route Finder - Boston Metro System");

        scene = new Scene(theView.asParent());
        window.setScene(scene);
        window.show();
    }
}
