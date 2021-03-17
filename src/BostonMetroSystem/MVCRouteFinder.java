package BostonMetroSystem;

import java.util.List;

public class MVCRouteFinder {
    public static void main(String[] args){
        /*

        RouteFinderView theView = new RouteFinderView();

        RouteFinderModel theModel = new RouteFinderModel();

        RouteFinderController theController = new RouteFinderController(theView, theModel);

        theView.setVisible(true);

        Parser parse = new Parser();

        parse.readFile();
        parse.parseFile();

         */

        MetroGraph graph = new MetroGraph();

        Station s1 = new Station(1, "Station1");
        Station s2 = new Station(2, "Station2");
        Station s3 = new Station(3, "Station3");
        Station s4 = new Station(4, "Station4");
        Station s5 = new Station(5, "Station5");
        Station s6 = new Station(6, "Station6");

        graph.addVertex(s1);
        graph.addVertex(s2);
        graph.addVertex(s3);
        graph.addVertex(s4);
        graph.addVertex(s5);
        graph.addVertex(s6);

        graph.addEdge(s1,s2, "red") ;
        graph.addEdge(s1,s3, "blue");
        graph.addEdge(s1,s5, "orange");
        graph.addEdge(s2,s4, "red");
        graph.addEdge(s2,s5, "orange");
        graph.addEdge(s3,s5, "blue");





        RouteCalculator rc = new RouteCalculator(graph);

        List<Station> route = rc.calculateRoute(s1, s5);

        for(int i = 0; i < route.size(); i++){
            System.out.println(route.get(i).getStation());
        }

         /*
        List<StationColorPair> s1AdjVertices = graph.getAdjVertices(s1);
        List<StationColorPair> s2AdjVertices = graph.getAdjVertices(s2);
        List<StationColorPair> s3AdjVertices = graph.getAdjVertices(s3);
        List<StationColorPair> s4AdjVertices = graph.getAdjVertices(s4);
        List<StationColorPair> s5AdjVertices = graph.getAdjVertices(s5);

        System.out.println("---Station 1 Adj Vertices ----");
        for(int i = 0; i < s1AdjVertices.size(); i++){
            System.out.println(s1AdjVertices.get(i).getKey().getID());
            System.out.println(s1AdjVertices.get(i).getKey().getStation());
            System.out.println(s1AdjVertices.get(i).getValue());
        }

        System.out.println();
        System.out.println("---Station 2 Adj Vertices ----");
        for(int i = 0; i < s2AdjVertices.size(); i++){
            System.out.println(s2AdjVertices.get(i).getKey().getID());
            System.out.println(s2AdjVertices.get(i).getKey().getStation());
            System.out.println(s2AdjVertices.get(i).getValue());
        }

        System.out.println();
        System.out.println("---Station 3 Adj Vertices ----");
        for(int i = 0; i < s3AdjVertices.size(); i++){
            System.out.println(s3AdjVertices.get(i).getKey().getID());
            System.out.println(s3AdjVertices.get(i).getKey().getStation());
            System.out.println(s3AdjVertices.get(i).getValue());
        }

        System.out.println();
        System.out.println("---Station 4 Adj Vertices ----");
        for(int i = 0; i < s4AdjVertices.size(); i++){
            System.out.println(s4AdjVertices.get(i).getKey().getID());
            System.out.println(s4AdjVertices.get(i).getKey().getStation());
            System.out.println(s4AdjVertices.get(i).getValue());
        }

        System.out.println();
        System.out.println("---Station 5 Adj Vertices ----");
        for(int i = 0; i < s5AdjVertices.size(); i++){
            System.out.println(s5AdjVertices.get(i).getKey().getID());
            System.out.println(s5AdjVertices.get(i).getKey().getStation());
            System.out.println(s5AdjVertices.get(i).getValue());
        }

         */






    }
}
