package BostonMetroSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetroGraph implements Graph<Station, StationColourPair, Integer>{
    //maps a stationID to a list of its neighbours
    //stationcolourpair contains neighbouring stationID and line colour
    private Map<Integer, List<StationColourPair>>  adjVertices;

    public MetroGraph(){
        adjVertices = new HashMap<>();

    }

    //adds id of given station to graph
    public void addVertex(Station station){
        //adds vertex using station id as a map
        adjVertices.putIfAbsent(station.getID(), new ArrayList<>());
    }

    //takes all neighbours of a given station, converts into stationcolour pairs
    //then appends to list.
    public void addEdge(Station station){
        List<Neighbour> neighbours = station.getNeighbours();

        for(int i = 0; i < neighbours.size(); i++){
            StationColourPair firstNeighbour = new StationColourPair(neighbours.get(i).getFirst(),neighbours.get(i).getColour());
            StationColourPair secondNeighbour = new StationColourPair(neighbours.get(i).getSecond(),neighbours.get(i).getColour());

            adjVertices.get(station.getID()).add(firstNeighbour);
            adjVertices.get(station.getID()).add(secondNeighbour);
        }
    }

    public List<StationColourPair> getAdjVertices(Integer s){
        return adjVertices.get(s);
    }


}
