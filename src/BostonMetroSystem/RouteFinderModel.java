package BostonMetroSystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class RouteFinderModel {
    //used to store stations that can be returned to view and also used to initialise graph
    private ArrayList<Station> stations;
    private MetroGraph graph;
    private String startSelectInput;
    private String endSelectInput;
    private int startID;
    private int endID;
    private ArrayList<String> displayRoute;
    private ListView<String> tempList = new ListView<>();


    Parser parse = new Parser();

    public RouteFinderModel(){
        this.stations = this.parseFile();
        this.graph = new MetroGraph();
        this.initialiseGraph();
        this.startID =0;
        this.endID =0;
        this.startSelectInput = "";
        this.endSelectInput = "";
        this.displayRoute = new ArrayList<>();
    }

    public ArrayList parseFile(){

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


    public void calculateRoute(int startStationID, int endStationID){
        RouteCalculator rc = new RouteCalculator();

        List<Station> route = rc.findRoute(graph, stations.get(startStationID -1), stations.get(endStationID -1));


        for(Station i : route){
           setStationDisplayRoute(i);
        }


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

    }


    public void setEndSelectInput(String input){
        this.endSelectInput = input;

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
                String getStart = getStartSelectInput();
                String getEnd = getEndSelectInput();

                setStartID(getStart);
                setEndID(getEnd);

                int stationStartID = getStartID();
                int stationEndID = getEndID();


                calculateRoute(stationStartID, stationEndID);

                setUpdateRouteListView();
                getUpdateRouteListView();



            }
        };

        findRouteButton.setOnAction(click);

    }

    public void setStartID(String startID1){
        //converting id into an int
        String parsedId = parse.parseVal(startID1);
        int id = Integer.parseInt(parsedId);
        this.startID = id;


    }

    public void setEndID(String endID1){

        String parsedId = parse.parseVal(endID1);
        int id = Integer.parseInt(parsedId);
        this.endID = id;

    }

    public int getStartID(){
        return this.startID;
    }

    public int getEndID(){
        return this.endID;
    }

    public void setStationDisplayRoute(Station stationID){


        for(Station station : stations){
            if(station == stationID){
               displayRoute.add(station.stationAsString());
            }
        }

    }

    public ArrayList<String> getDisplayRoute(){
        for (int i = 0; i < displayRoute.size(); i++) {
            System.out.println(displayRoute.get(i));

        }
        return displayRoute;
    }

    public void setUpdateRouteListView(){
        ArrayList<String> tempArrayList = getDisplayRoute();
        tempList.getItems().clear();
        for(String s: tempArrayList){
            tempList.getItems().add(s);
        }
        tempArrayList.clear();

    }

    public ListView<String> getUpdateRouteListView(){
        //System.out.println(tempList.getItems().toString());
        return  tempList;
    }








}
