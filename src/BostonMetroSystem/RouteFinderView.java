package BostonMetroSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class RouteFinderView{
    private RouteFinderModel theModel;
    private RouteFinderController theController;
    javafx.scene.control.Button button;
    BorderPane pane;
    ListView<String> startListView;
    ListView<String> endListView;
    ListView<String> routeListView;
    javafx.scene.control.Label start;
    javafx.scene.control.Label end;
    Label route;
    TextField searchStart;
    TextField searchEnd;
    private ArrayList<Station> stations;

    public RouteFinderView(RouteFinderController theController, RouteFinderModel theModel){
        this.theController = theController;
        this.theModel = theModel;

        pane = new BorderPane();
        button = new javafx.scene.control.Button("Find Route");
        start = new javafx.scene.control.Label("Start Destination");
        end = new javafx.scene.control.Label("End Destination");
        route = new javafx.scene.control.Label("Route:");
        searchStart = new javafx.scene.control.TextField();
        searchStart.setPromptText("Search");
        searchEnd = new TextField();
        searchEnd.setPromptText("Search");

        startListView = new ListView<>();
        endListView = new ListView<>();
        routeListView = new ListView<>();
        routeListView.setFixedCellSize(10);
        stations = theController.getStations();
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
    }

    public Parent asParent() {
        return pane ;
    }
}
