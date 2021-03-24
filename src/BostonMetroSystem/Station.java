package BostonMetroSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Station {

    private int ID;
    private String station;
    private ArrayList<Neighbour> neighbours;

    public Station(int ID, String station, ArrayList<Neighbour> neighbours){
        this.ID = ID;
        this.station = station;
        this.neighbours = neighbours;
    }

    public int getID() {
        return ID;
    }

    public String getStation() {
        return station;
    }

    public ArrayList<Neighbour> getNeighbours() {return neighbours;}
}
