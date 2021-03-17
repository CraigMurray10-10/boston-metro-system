package BostonMetroSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MetroGraph implements Graph<Station, StationColorPair> {
    HashMap <Station, List<StationColorPair>> adjStations;



    public MetroGraph() {
        //RouteCalculator routeCalc = new RouteCalculator(station1, station2);
        //Parser metroParser = new Parser();
        adjStations = new HashMap<>();
    }

    public  HashMap <Station, List<StationColorPair>> getAllStations(){
        return adjStations;
    }

    public void addVertex(Station newStation) {
        //vertex added to list of vertices with empty array list
        adjStations.putIfAbsent(newStation, new ArrayList<>());

    }

    public void addEdge(Station src, Station dest, String color) {
        StationColorPair srcToDest = new StationColorPair(dest, color);
        StationColorPair destToSrc = new StationColorPair(src, color);


        adjStations.get(src).add(srcToDest);
        adjStations.get(dest).add(destToSrc);
    }

    public List<StationColorPair> getAdjVertices(Station station) {
        return adjStations.get(station);
    }

}
