package BostonMetroSystem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
    ListView<String> tempRoutesListView;
    javafx.scene.control.Label start;
    javafx.scene.control.Label end;
    Label route;
    TextField searchStart;
    TextField searchEnd;
    ObservableList<String> starts;
    ObservableList<String> ends;
    ObservableList<String> routes = FXCollections.observableArrayList();



    private ArrayList<Station> stations;
    public RouteFinderView(ArrayList<Station> stations) {
        this.stations = stations;

        this.initialiseWindow();
    }


    /*public void initialiseWindow() {

    }*/

    public void initialiseWindow() {
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
        starts = FXCollections.observableArrayList();
        ends = FXCollections.observableArrayList();
        routes = getRoutes();


        for (Station s : this.stations) {
            starts.add(s.stationAsString());
            ends.add(s.stationAsString());
        }
        startListView.setItems(starts);
        startListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        endListView.setItems(ends);
        endListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        routes.add("Hello");
        routeListView.setItems(routes);
        routeListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);





        VBox leftPane = new VBox(start, startListView, searchStart);
        VBox middlePane = new VBox(end, endListView, searchEnd);
        VBox rightPane = new VBox(route, routeListView, button);

        HBox layout = new HBox(20);
        layout.setPadding(new Insets(20, 20, 20,20));
        layout.getChildren().addAll(leftPane, middlePane, rightPane);
        pane.setCenter(layout);





    }




    public Parent asParent(){
        return pane;
    }


    public ListView<String> getStartSelectInput(){
        return startListView;
    }

    public ListView<String> getEndSelectInput(){return endListView;}

    public TextField getSearchStart(){
        return searchStart;
    }

    public TextField getSearchEnd(){
        return searchEnd;
    }

    public ListView<String> getRouteListView(){return routeListView;}

    public Button getButton() {
        return button;
    }

    public void searchStartUserInput(TextField startInput, ObservableList<String> starts){
        System.out.println("checking start list " + starts.size());
        FilteredList<String> filterStart = new FilteredList<>(starts, item -> true);

        startInput.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);

            if(newValue == null || newValue.length() == 0){
                filterStart.setPredicate(item -> true);
                this.startListView.setItems(filterStart);
                System.out.println(filterStart + " " + filterStart.size());
            } else {
                filterStart.setPredicate(item -> item.contains(newValue));
                this.startListView.setItems(filterStart);
                System.out.println(filterStart + " " + filterStart.size());
            }
        });
    }

    public void searchEndUserInput(TextField startInput, ObservableList<String> ends){
        System.out.println("checking start list " + ends.size());
        FilteredList<String> filterEnd = new FilteredList<>(ends, item -> true);

        startInput.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);

            if(newValue == null || newValue.length() == 0){
                filterEnd.setPredicate(item -> true);
                this.endListView.setItems(filterEnd);
                System.out.println(filterEnd + " " +filterEnd.size());
            } else {
                filterEnd.setPredicate(item -> item.contains(newValue));
                this.endListView.setItems(filterEnd);
                System.out.println(filterEnd + " " +filterEnd.size());
            }
        });
    }

    public ObservableList<String> getRoutes(){
        return routes;
    }

    public void setRoutes(ArrayList<String> route){
        this.routes.clear();
        this.routes.addAll(route);
        System.out.println(route);

    }


    public void updateRoutes(ListView<String> getRoutes){
        routeListView.setItems(getRoutes.getItems());


    }

}

