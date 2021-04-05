package BostonMetroSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Station {

    private int ID;
    private String station;
    private ArrayList<Neighbour> neighbours;

    /**
     * Station constructor
     * @param ID
     * @param station
     * @param neighbours
     */
    public Station(int ID, String station, ArrayList<Neighbour> neighbours){
        this.ID = ID;
        this.station = station.trim();
        this.neighbours = neighbours;
    }

    /**
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return station
     */
    public String getStation() {
        return station;
    }

    /**
     * @return neighbours
     */
    public ArrayList<Neighbour> getNeighbours() {return neighbours;}

    /**
     * @return 
     */
    public String stationAsString(){
        return (this.ID + " " + this.station);
    }
}
