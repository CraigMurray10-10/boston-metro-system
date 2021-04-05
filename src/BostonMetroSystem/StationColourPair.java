package BostonMetroSystem;

import java.util.Map;

public class StationColourPair implements Pair<Station,String>{
    private Station key;
    private String color;

    /**
     * StationColourPair constructor
     * @param key
     * @param color
     */
    public StationColourPair(Station key, String color){
        this.key = key;
        this.color = color;
    }

    /**
     * returns the station object
     * @return this.key
     */
    @Override
    public Station getKey() {
        return this.key;
    }

    /**
     * returns the color of the line associated (as when use stationColourPair it is always when referring to neighbouring nodes)
     * @return this.color
     */
    @Override
    public String getValue() {
        return this.color;
    }



}

