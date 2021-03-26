package BostonMetroSystem;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MVCRouteFinder extends Application {
    Stage window;
    Scene scene;
    Button button;
    BorderPane pane;
    ListView<String> startListView;
    ListView<String> endListView;
    ListView<String> routeListView;
    Label start;
    Label end;
    Label route;
    TextField searchStart;
    TextField searchEnd;

    private ObservableList<String> stations;
    private RouteFinderModel theModel;
    private RouteFinderController theController;
    private RouteFinderView theView;

    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        theModel = new RouteFinderModel();
        theView = new RouteFinderView();
        theController = new RouteFinderController(theView, theModel);

        window = stage;
        window.setTitle("Route Finder - Boston Metro System");

        pane = new BorderPane();
        button = new Button("Find Route");
        start = new Label("Start Destination");
        end = new Label("End Destination");
        route = new Label("Route:");
        searchStart = new TextField();
        searchStart.setPromptText("Search");
        searchEnd = new TextField();
        searchEnd.setPromptText("Search");

        startListView = new ListView<>();
        endListView = new ListView<>();
        routeListView = new ListView<>();
        routeListView.setFixedCellSize(10);
        ArrayList<Station> stations = theController.getStations();
        ObservableList<String> starts = FXCollections.observableArrayList();
        ObservableList<String> ends = FXCollections.observableArrayList();
        for(Station s: stations){
            starts.add(s.stationAsString());
            ends.add(s.stationAsString());
        }
        startListView.setItems(starts);
        startListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        endListView.setItems(ends);
        endListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        VBox leftPane = new VBox(start, startListView, searchStart);
        VBox middlePane = new VBox(end, endListView, searchEnd);
        VBox rightPane = new VBox(route, routeListView, button);

        HBox layout = new HBox(20);
        layout.setPadding(new Insets(20, 20, 20,20));
        layout.getChildren().addAll(leftPane, middlePane, rightPane);

        pane.setCenter(layout);
        scene = new Scene(pane, 700, 500);
        window.setScene(scene);
        window.show();
    }
}
