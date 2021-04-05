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

    /**
     * MetroGraph constructor
     */
    public MetroGraph(){
        adjVertices = new HashMap<>();
        this.stations = new ArrayList<>();
    }

    /**
     * Method adds a station object to the graph (where station is a vertex)
     * @param station
     */
    //adds id of given station to graph
    public void addVertex(Station station){
        //adds vertex using station id as a map
        adjVertices.putIfAbsent(station, new ArrayList<>());
        stations.add(station);
    }

    /**
     * Method creates an edge in the graph between 2 existing vertices
     * @param station
     */
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

    /**
     * Method is used when creating edges to take the stationID from a neighbour object and return the station object associated.
     * @param stationNumber
     * @return
     */
    public Station findStation(int stationNumber){
        for (Station st : stations){
            if (st.getID() == stationNumber){
                return st;
            }
        }
        return null;
    }

    /**
     * method used to return all vertices in the graph
     * @return adjVertices.get(s)
     */
    public List<Station> getAllVertices(){
        return this.stations;
    }

    /**
     * method used to get all adjacent vertices from a single station.
     * @return adjVertices.get(s)
     */
    public List<StationColourPair> getAdjVertices(Station s){
        return adjVertices.get(s);
    }


}
