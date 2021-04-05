package BostonMetroSystem.test;

import BostonMetroSystem.MetroGraph;
import BostonMetroSystem.Neighbour;
import BostonMetroSystem.RouteCalculator;
import BostonMetroSystem.Station;
import BostonMetroSystem.StationColourPair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * tests that the methods within MetroGraph can be used to represent a graph.
 */
public class MetroGraphTest {

    private MetroGraph graph;
    private RouteCalculator rc;
    ArrayList<Station> stations;
    private Station s1;
    private Station s2;
    private Station s3;
    private Station s4;
    private Station s5;



    /**
     * Creates initial graph to be tested
     * @return void
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

        stations = new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5));

        graph = new MetroGraph();

        for(Station s: stations){
            graph.addVertex(s);
        }

        for(Station s: stations){
            graph.addEdge(s);
        }
    }


    /**
     * tests vertices are successfully added to graph
     * @return void
     */
    @Test
    public void checkVerticesAdded(){
        List<Station> allVertices = graph.getAllVertices();
        assertAll(
                () -> assertEquals(allVertices, stations)
        );

    }

    /**
     * tests edges are successfully added
     * @return void
     */
    @Test
    public void checkNeighbouringNodes(){
        List<StationColourPair> s1ActualNeighbours = graph.getAdjVertices(s1);
        List<StationColourPair> s1ExpectedNeighbours = new ArrayList<>(Arrays.asList(
                new StationColourPair(s2, "red"),
                new StationColourPair(s3, "blue")
        ));



        assertAll(
                () -> assertEquals(s1ActualNeighbours.get(0).getKey(), s1ExpectedNeighbours.get(0).getKey()),
                () -> assertEquals(s1ActualNeighbours.get(0).getValue(), s1ExpectedNeighbours.get(0).getValue()),
                () -> assertEquals(s1ActualNeighbours.get(1).getKey(), s1ExpectedNeighbours.get(1).getKey()),
                () -> assertEquals(s1ActualNeighbours.get(1).getValue(), s1ExpectedNeighbours.get(1).getValue()),
                () -> assertEquals(s1ActualNeighbours.size(), s1ExpectedNeighbours.size())
        );

    }


}
