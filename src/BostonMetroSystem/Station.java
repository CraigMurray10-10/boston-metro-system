package BostonMetroSystem;

import java.util.List;

public class Station {
    public Station(int ID, String station, List<Neighbour> neighbours){
        this.ID = ID;
        this.station = station;
        this.neighbours = neighbours;
    }

}
