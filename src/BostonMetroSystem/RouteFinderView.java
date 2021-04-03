package BostonMetroSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class RouteFinderView{
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
    ObservableList<String> starts;
    ObservableList<String> ends;


    private ArrayList<Station> stations;

    public RouteFinderView(ArrayList<Station> stations) {
        this.stations = stations;

        this.initialiseWindow();

    }

    public void initialiseWindow(){
        starts = FXCollections.observableArrayList();
        ends = FXCollections.observableArrayList();

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

    public ListView<String> getStartSelectInput(){
        return startListView;
    }

    public ListView<String> getEndSelectInput(){return endListView;}

    public Button getButton() {
        return button;
    }

}
