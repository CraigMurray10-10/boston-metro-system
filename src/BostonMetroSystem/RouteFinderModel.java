package BostonMetroSystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class RouteFinderModel {
    //used to store stations that can be returned to view and also used to initialise graph
    private ArrayList<Station> stations;
    private MetroGraph graph;
    private String startSelectInput = "";
    private String endSelectInput = "";


    public RouteFinderModel(){
        this.stations = this.parseFile();
        this.graph = new MetroGraph();
        this.initialiseGraph();
        this.calculateRoute();
    }

    public ArrayList parseFile(){
        Parser parse = new Parser();
        ArrayList<Station> stations = parse.parseFile();

        return stations;
    }

    //getters & setters
    public ArrayList<Station> getStations(){
        return this.stations;
    }

    public void initialiseGraph(){
        for(Station s: stations){
            graph.addVertex(s);
        }

        for(Station s: stations){
            graph.addEdge(s);
        }
    }

    public void calculateRoute(){
        RouteCalculator rc = new RouteCalculator();

        //TODO: put users inputted source and destination
        List<Station> route = rc.findRoute(graph, stations.get(32), stations.get(27));

        for(Station i : route){
            System.out.println(i.getID() + " " + i.getStation());
        }
    }

    public void searchStartUserInput(TextField startInput, ObservableList<String> starts){
        System.out.println("checking start list " + starts.size());
        FilteredList<String> filterStart = new FilteredList<>(starts, item -> true);

        startInput.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);

            if(newValue == null || newValue.length() == 0){
                filterStart.setPredicate(item -> true);
                System.out.println(filterStart.size());
            } else {
                filterStart.setPredicate(item -> item.contains(newValue));
                System.out.println(filterStart.size());
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
                System.out.println(filterEnd.size());
            } else {
                filterEnd.setPredicate(item -> item.contains(newValue));
                System.out.println(filterEnd.size());
            }
        });
    }

    public void userInputSelectStart(ListView<String> startInput){
        startInput.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            String selectedItem = "";
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedItem = startInput.getSelectionModel().getSelectedItem();
                setStartSelectInput(selectedItem);
            }
        });
    }

    public void setUserInputSelectEnd(ListView<String> endInput){
        endInput.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            String selectedItem = "";
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedItem = endInput.getSelectionModel().getSelectedItem();
                setEndSelectInput(selectedItem);
            }
        });
    }

    public void setStartSelectInput(String input){
        this.startSelectInput = input;
        System.out.println(startSelectInput);
    }

    public void setEndSelectInput(String input){
        this.endSelectInput = input;
        System.out.println(endSelectInput);
    }

    public String getStartSelectInput(){
        return  this.startSelectInput;
    }

    public String getEndSelectInput(){
        return  this.endSelectInput;
    }

    public void setButtonInput(javafx.scene.control.Button findRouteButton){
        EventHandler<ActionEvent> click = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Start is " + getStartSelectInput());
                System.out.println("End is " + getEndSelectInput());
            }
        };
        findRouteButton.setOnAction(click);
    }

    public void setRouteOutput(ListView<String> routeOutput){

    }
}
