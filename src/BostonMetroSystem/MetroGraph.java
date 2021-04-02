package BostonMetroSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetroGraph implements Graph<Station, StationColourPair>{
    //maps a stationID to a list of its neighbours
    //stationcolourpair contains neighbouring stationID and line colour
    private Map<Station, List<StationColourPair>>  adjVertices;
    private List<Station> stations;

    public MetroGraph(List<Station> stations){
        adjVertices = new HashMap<>();
        this.stations = stations;

    }

    //adds id of given station to graph
    public void addVertex(Station station){
        //adds vertex using station id as a map
        adjVertices.putIfAbsent(station, new ArrayList<>());
    }

    //takes all neighbours of a given station, converts into stationcolour pairs
    //then appends to list.
    public void addEdge(Station station){
        List<Neighbour> neighbours = station.getNeighbours();

        for(int i = 0; i < neighbours.size(); i++){
            Station firstStationNeighbour = this.findStation(neighbours.get(i).getFirst());
            Station secondStationNeighbour = this.findStation(neighbours.get(i).getSecond());

            if (firstStationNeighbour != null) {
                StationColourPair firstNeighbour = new StationColourPair(firstStationNeighbour, neighbours.get(i).getColour());
                adjVertices.get(station).add(firstNeighbour);
            }

            if (secondStationNeighbour != null) {
                StationColourPair secondNeighbour = new StationColourPair(secondStationNeighbour,neighbours.get(i).getColour());
                adjVertices.get(station).add(secondNeighbour);

            }
        }
    }

    public Station findStation(int stationNumber){
        for (Station st : stations){
            if (st.getID() == stationNumber){
                return st;
            }
        }
        return null;
    }

    public List<StationColourPair> getAdjVertices(Station s){
        return adjVertices.get(s);
    }


}
