package BostonMetroSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RouteFinderTest {

    private MetroGraph graph;
    private RouteCalculator rc;
    private Station s1;
    private Station s2;
    private Station s3;
    private Station s4;
    private Station s5;
    private Station s6;

    //initialise graph to be searched
    @BeforeEach
    public void setUp(){
        graph = new MetroGraph();

        s1 = new Station(1, "Station1");
        s2 = new Station(2, "Station2");
        s3 = new Station(3, "Station3");
        s4 = new Station(4, "Station4");
        s5 = new Station(5, "Station5");
        s6 = new Station(6, "Station6");

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

        rc = new RouteCalculator(graph);


    }

    @Test
    public void searchNoEqualPathLengths(){


        List<Station> route1 = rc.calculateRoute(s1, s5);
        List<Station> expectedRoute1 = new ArrayList<>(Arrays.asList(s1,s5));

        Station s4 = new Station(4, "Station4");
        List<Station> route2 = rc.calculateRoute(s1, s4);

        List<Station> expectedRoute2 = new ArrayList<>(Arrays.asList(s1,s2,s4));

        assertAll(
                () -> assertEquals(route1, expectedRoute1)
        );
    }


}
