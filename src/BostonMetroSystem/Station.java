package BostonMetroSystem;

import java.util.List;
import java.util.Map;

public class Station {

    private int ID;
    private String station;

    public Station(int ID, String station){
        this.ID = ID;
        this.station = station;
    }

    public int getID() {
        return ID;
    }

    public String getStation() {
        return station;
    }
}
