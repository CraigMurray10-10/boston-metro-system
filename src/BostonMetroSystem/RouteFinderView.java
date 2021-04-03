package BostonMetroSystem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    ListView<String> displayRouteListView;
    ListView<String> getRouteListView;
    javafx.scene.control.Label start;
    javafx.scene.control.Label end;
    Label route;
    TextField searchStart;
    TextField searchEnd;
    ObservableList<String> starts = FXCollections.observableArrayList();
    ObservableList<String> ends = FXCollections.observableArrayList();
    ObservableList<String> routes = FXCollections.observableArrayList();


    private ArrayList<Station> stations;




    public RouteFinderView(RouteFinderController theController) {
        pane = new BorderPane();
        button = new javafx.scene.control.Button("Find Route");
        start = new javafx.scene.control.Label("Start Destination");
        end = new javafx.scene.control.Label("End Destination");
        route = new javafx.scene.control.Label("Route:");
        searchStart = new javafx.scene.control.TextField();
        searchStart.setPromptText("Search");
        searchEnd = new TextField();
        searchEnd.setPromptText("Search");
        stations = theController.getStations();
        startListView = new ListView<>();
        endListView = new ListView<>();
        displayRouteListView = new ListView<>();
        displayRouteListView.setFixedCellSize(10);
        getRouteListView =new ListView<>();

        for (Station s : this.stations) {
            starts.add(s.stationAsString());
            ends.add(s.stationAsString());
        }
        startListView.setItems(starts);
        startListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        endListView.setItems(ends);
        endListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        displayRouteListView = test();



        VBox leftPane = new VBox(start, startListView, searchStart);
        VBox middlePane = new VBox(end, endListView, searchEnd);
        VBox rightPane = new VBox(route, displayRouteListView, button);

        HBox layout = new HBox(20);
        layout.setPadding(new Insets(20, 20, 20, 20));
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

    public void displayRoute(@org.jetbrains.annotations.NotNull ArrayList<String> routeList){

        ListView<String> tempListView = new ListView<>();

        for(String route : routeList){
            routes.add(route);

        }


        tempListView.setItems(routes);

        getRouteListView = tempListView;

        System.out.println(getRouteListView.getItems().toString());


    }

    public ListView<String> test(){
        System.out.println(getRouteListView.getItems().toString());
       return getRouteListView;

    }
}
