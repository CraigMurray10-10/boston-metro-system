package BostonMetroSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MetroGraphTest {
    private MetroGraph graph;

    @BeforeEach
    public void setUp(){
        graph = new MetroGraph();

    }

    @Test
    public void testAddVertex() {
        Station station = new Station(1, "testStation");
        graph.addVertex(station);

        assertNotEquals(graph.getAllStations().get(station) , null  );
    }

    @Test
    public void testAddEdge() {
        Station stationSrc = new Station(1, "testStation");
        Station stationDest = new Station(2, "testStation2");

        graph.addVertex(stationSrc);
        graph.addVertex(stationDest);
        graph.addEdge(stationSrc, stationDest, "red");


        assertAll(
                () -> assertNotEquals(graph.getAdjVertices(stationSrc),null),
                () -> assertEquals(graph.getAdjVertices(stationSrc).get(0).getKey(),stationDest),
                () -> assertEquals(graph.getAdjVertices(stationSrc).get(0).getValue(),"red"),
                () -> assertNotEquals(graph.getAdjVertices(stationDest),null),
                () -> assertEquals(graph.getAdjVertices(stationDest).get(0).getKey(),stationSrc),
                () -> assertEquals(graph.getAdjVertices(stationDest).get(0).getValue(),"red")
                );
    }

    @Test
    public void getAdjVertices(){
        Station stationSrc = new Station(1, "testStation");
        Station stationDest = new Station(2, "testStation2");

        graph.addVertex(stationSrc);
        graph.addVertex(stationDest);
        graph.addEdge(stationSrc, stationDest, "red");

        List<StationColorPair> expectedSrcAdjList = new ArrayList<>();
        expectedSrcAdjList.add(new StationColorPair(stationDest, "red"));

        List<StationColorPair> expectedDestAdjList = new ArrayList<>();
        expectedDestAdjList.add(new StationColorPair(stationSrc, "red"));


        assertAll(
                () -> assertEquals(graph.getAdjVertices(stationSrc).get(0).getKey(),expectedSrcAdjList.get(0).getKey()),
                () -> assertEquals(graph.getAdjVertices(stationSrc).get(0).getValue(),expectedSrcAdjList.get(0).getValue()),
                () -> assertEquals(graph.getAdjVertices(stationDest).get(0).getKey(),expectedDestAdjList.get(0).getKey()),
                () -> assertEquals(graph.getAdjVertices(stationDest).get(0).getValue(),expectedDestAdjList.get(0).getValue())
        );






    }
}
