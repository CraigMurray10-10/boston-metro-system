package BostonMetroSystem.test;
import BostonMetroSystem.MetroGraph;
import BostonMetroSystem.Neighbour;
import BostonMetroSystem.RouteCalculator;
import BostonMetroSystem.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * tests RouteCalculator can successfully calculate a route between nodes
 */
public class RouteCalculatorTest {

    private MetroGraph graph;
    private RouteCalculator rc;
    private Station s1;
    private Station s2;
    private Station s3;
    private Station s4;
    private Station s5;


    /**
     * Creates initial graph to be tested
     *
     */
    //initialise graph to be searched
    @BeforeEach
    public void setUp(){

        rc = new RouteCalculator();

        s1 = new Station(1, "Station1", new ArrayList<>(Arrays.asList(new Neighbour("red", 0, 2),
                                                                                new Neighbour("blue", 0, 3))));
        s2 = new Station(2, "Station2", new ArrayList<>(Arrays.asList(new Neighbour("red", 1, 4),
                                                                                 new Neighbour("blue", 0, 5))));
        s3 = new Station(3, "Station3", new ArrayList<>(Arrays.asList(new Neighbour("blue", 1, 5))));
        s4 = new Station(4, "Station4", new ArrayList<>(Arrays.asList(new Neighbour("red", 2, 5))));
        s5 = new Station(5, "Station5", new ArrayList<>(Arrays.asList(new Neighbour("blue" , 3, 0))));

        ArrayList<Station> stations = new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5));

        graph = new MetroGraph();

        for(Station s: stations){
            graph.addVertex(s);
        }

        for(Station s: stations){
            graph.addEdge(s);
        }
    }


    /**
     * checks correct path is returned when there is only one path with the shortest possible length
     *
     */
    @Test
    public void searchNoEqualPathLengths(){
        List<Station> route1 = rc.findRoute(graph, s1, s4);
        List<Station> expectedRoute1 = new ArrayList<>(Arrays.asList(s1,s2,s4));


        assertAll(
                () -> assertEquals(route1, expectedRoute1)
        );

    }


    /**
     * checks correct path is returned when there is more than one possible route with shortest possible length
     *
     */
    @Test
    public void searchEqualPathLengths(){
        List<Station> route1 = rc.findRoute(graph, s1, s5);
        List<Station> expectedRoute1 = new ArrayList<>(Arrays.asList(s1,s3,s5));
        assertAll(
                () -> assertEquals(route1, expectedRoute1)
        );
    }


    /**
     * checks that the number of line switches occuring within a route is correct
     *
     */
    @Test
    public void calculateLineSwitchTest(){
        List<Station> route1 = rc.findRoute(graph, s1, s5);
        int actualLineSwitch1 = rc.calculateLineSwitches(route1, graph);
        int expectedLineSwitch1 = 0;

        List<Station> route2 = rc.findRoute(graph, s3, s4);
        int actualLineSwitch2 = rc.calculateLineSwitches(route2, graph);
        int expectedLineSwitch2 = 1;

        assertAll(
                () -> assertEquals(actualLineSwitch1, expectedLineSwitch1),
                () -> assertEquals(actualLineSwitch2, expectedLineSwitch2)

        );
    }


    /**
     * checks that the route with lowest integer value associated is returned.
     *
     */
     @Test
    public void testBestRoute(){
        //building a fake agenda to check testBestRoute returns route with lowest value
         Map<List<Station>, Integer> agenda = new HashMap<>();

         List<Station> route1 = rc.findRoute(graph, s1, s5);
         List<Station> route2 = rc.findRoute(graph, s3, s4);

         agenda.put(route1, 0);
         agenda.put(route2, 1);

         List<Station> routeReturned = rc.getBestRoute(agenda);

         assertAll(
                 () -> assertEquals(route1, routeReturned)
         );



     }




}
