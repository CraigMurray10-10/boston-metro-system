package BostonMetroSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MetroGraph implements Graph<Station>{
    HashMap <Station, List<Station>> adjStations = new HashMap<>();


    public MetroGraph() {


        //RouteCalculator routeCalc = new RouteCalculator(station1, station2);
        //Parser metroParser = new Parser();
    }

    public void addVertex(Station newStation) {
        //vertex added to list of vertices with empty array list
        adjStations.putIfAbsent(newStation, new ArrayList<>());

    }

    public void addEdge(Station src, Station dest) {

        adjStations.get(src).add(dest);
        adjStations.get(dest).add(src);
    }

    public List<Station> getAdjVertices(Station station) {
        return adjStations.get(station);
    }

}
