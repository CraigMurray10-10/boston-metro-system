package BostonMetroSystem;

import java.util.ArrayList;

/**
 * represents a station within the Metro System
 */

public class Station {

    private int ID;
    private String station;
    private ArrayList<Neighbour> neighbours;

    /**
     * Station constructor
     * @param ID the id of the station
     * @param station the name of the station
     * @param neighbours list of neighbouring stations
     */
    public Station(int ID, String station, ArrayList<Neighbour> neighbours){
        this.ID = ID;
        this.station = station.trim();
        this.neighbours = neighbours;
    }

    /**
     * Method used to get station id of an object
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * method used to get the station name of an object.
     * @return station
     */
    public String getStation() {
        return station;
    }

    /**
     * method used to get the neighbours of the object
     * @return neighbours
     */
    public ArrayList<Neighbour> getNeighbours() {return neighbours;}

    /**
     * method formats the id and station name as a string that can be outputted and returns said string
     * @return
     */
    public String stationAsString(){
        return (this.ID + " " + this.station);
    }
}
