package BostonMetroSystem;

public class MetroGraph implements Graph{
    public MetroGraph() {
        Station station1 = new Station();
        Station station2 = new Station();
        RouteCalculator routeCalc = new RouteCalculator(station1, station2);
    }
}
