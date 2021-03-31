package BostonMetroSystem;

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

}
