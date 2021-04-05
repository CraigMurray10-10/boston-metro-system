package BostonMetroSystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class RouteFinderModel {
    //used to store stations that can be returned to view and also used to initialise graph
    private ArrayList<Station> stations;
    private MetroGraph graph;
    private String startSelectInput = "";
    private String endSelectInput = "";
    private int startID;
    private int endID;
    private ArrayList<String> displayRoute;
    private ListView<String> tempList = new ListView<>();

    Parser parse = new Parser();

    /**
     * RouteFinderModel constructor
     */
    public RouteFinderModel(){
        this.stations = this.parseFile("src/BostonMetroSystem/test.txt");
        this.graph = new MetroGraph();
        this.initialiseGraph();
        this.startID =0;
        this.endID =0;
        this.startSelectInput = "";
        this.endSelectInput = "";
        this.displayRoute = new ArrayList<>();
    }

    /**
     * Method parses a file into a list of stations
     * @param filepath
     * @return stations
     */
    public ArrayList parseFile(String filepath){
        ArrayList<Station> stations = parse.parseFile(filepath);

        return stations;
    }

    //getters & setters

    /**
     * @return this.stations
     */
    public ArrayList<Station> getStations(){
        return this.stations;
    }

    /**
     * Method initialises a graph
     */
    public void initialiseGraph(){
        for(Station s: stations){
            graph.addVertex(s);
        }

        for(Station s: stations){
            graph.addEdge(s);
        }

    }

    /**
     * Method calculates shortest route between 2 stations
     * @param startStationID
     * @param endStationID
     */
    public void calculateRoute(int startStationID, int endStationID){
        RouteCalculator rc = new RouteCalculator();

        List<Station> route = rc.findRoute(graph, stations.get(startStationID -1), stations.get(endStationID -1));


        for(Station i : route){
            setStationDisplayRoute(i);
        }


    }


    /**
     * Method passes what the user has selected from the passed in list view startInput to setStartSelectInput
     * @param startInput
     */
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

    /**
     * Method passes what the user has selected from the passed in list view endInput to setEndSelectInput
     * @param endInput
     */
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

    /**
     *
     * @param input
     */
    public void setStartSelectInput(String input){
        this.startSelectInput = input;

    }


    /**
     * @param input
     */
    public void setEndSelectInput(String input){
        this.endSelectInput = input;

    }

    /**
     * @return startSelectInput
     */
    public String getStartSelectInput(){
        return  this.startSelectInput;
    }

    /**
     * @return endSelectInput
     */
    public String getEndSelectInput(){
        return  this.endSelectInput;
    }

    /**
     * Outputs route from start to end destination to GUI
     * If start and or end destination missing outputs warning messages
     * @param findRouteButton
     */
    public void setButtonInput(javafx.scene.control.Button findRouteButton){
        EventHandler<ActionEvent> click = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String getStart = getStartSelectInput();
                String getEnd = getEndSelectInput();

                if(getStart == null && getEnd == null || getStart == "" && getEnd ==""){
                    Alert startAndEndEmpty = new Alert(Alert.AlertType.WARNING, "Please select make sure you have selected destinations");
                    startAndEndEmpty.showAndWait();
                }
                else if(getStart !="" && getEnd =="" || getStart !=null  && getEnd ==null){
                    Alert endEmpty = new Alert(Alert.AlertType.WARNING, "End destination empty");
                    endEmpty.showAndWait();

                }
                else if(getStart =="" && getEnd!=""  || getStart ==null && getEnd !=null){
                    Alert startEmpty = new Alert(Alert.AlertType.WARNING, "Start destination empty");
                    startEmpty.showAndWait();
                }


                if(getStart != null && getEnd !=null && getStart != "" && getEnd !="") {
                    setStartID(getStart);
                    setEndID(getEnd);

                    int stationStartID = getStartID();
                    int stationEndID = getEndID();


                    calculateRoute(stationStartID, stationEndID);

                    setUpdateRouteListView();
                    getUpdateRouteListView();
                }


            }
        };

        findRouteButton.setOnAction(click);

    }

    /**
     * sets startID equal to the integer value of a passed in string
     * @param startID1
     */
    public void setStartID(String startID1){

        String parsedId = parse.parseVal(startID1);
        int id = Integer.parseInt(parsedId);
        this.startID = id;


    }

    /**
     * sets endID equal to the integer value of a passed in string
     * @param endID1
     */
    public void setEndID(String endID1){

        String parsedId = parse.parseVal(endID1);
        int id = Integer.parseInt(parsedId);
        this.endID = id;

    }

    /**
     * @return startID
     */
    public int getStartID(){
        return this.startID;
    }

    /**
     * @return endID
     */
    public int getEndID(){
        return this.endID;
    }

    /**
     * Adds all stations on a route to an arrayList
     * @param stationID
     */
    public void setStationDisplayRoute(Station stationID){


        for(Station station : stations){
            if(station == stationID){
                displayRoute.add(station.stationAsString());
            }
        }

    }

    /**
     * @return displayRoute
     */
    public ArrayList<String> getDisplayRoute(){

        return displayRoute;
    }

    /**
     * Adds route from start to end destination arrayList to temporary ListView
     */
    public void setUpdateRouteListView(){
        ArrayList<String> tempArrayList = getDisplayRoute();
        tempList.getItems().clear();
        for(String s: tempArrayList){
            tempList.getItems().add(s);
        }
        tempArrayList.clear();

    }

    /**
     * @return tempList
     */
    public ListView<String> getUpdateRouteListView(){
        return  this.tempList;
    }


}
