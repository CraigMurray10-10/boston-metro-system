package BostonMetroSystem;

import java.util.HashMap;
import java.util.List;

public class MetroGraph implements Graph{
    public MetroGraph() {
        Station station1 = new Station();
        Station station2 = new Station();
        RouteCalculator routeCalc = new RouteCalculator(station1, station2);
        Parser metroParser = new Parser();
    }

    public void addVertex(int node) {

    }

    public void addEdge(int node1, int node2, String edge) {
    }

    public List<HashMap<Integer, String>> neighbours(int node) {
        return null;
    }
}
