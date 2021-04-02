package BostonMetroSystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class RouteFinderModel {
    //used to store stations that can be returned to view and also used to initialise graph
    private ArrayList<Station> stations;
    private MetroGraph graph;


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

        List<Integer> route = rc.findRoute(graph, stations.get(0), stations.get(6));

        for(int i : route){
            System.out.println(i);
        }

    }

    public void getUserInputStart(String userInputStart){
        System.out.println(userInputStart);
    }

    public void setUserInputSelectStart(ListView<String> startInput){
        startInput.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            String selectedItem = "";
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedItem = startInput.getSelectionModel().getSelectedItem();

            }

        });

    }

    public void setUserInputSelectEnd(ListView<String> endInput){
        endInput.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            String selectedItem = "";
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedItem = endInput.getSelectionModel().getSelectedItem();
                System.out.println("End " + selectedItem);
            }

        });


    }


}
