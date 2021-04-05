package BostonMetroSystem;

import java.util.Map;

public class StationColourPair extends Pair<Station,String>{
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
     * @return this.key
     */
    @Override
    public Station getKey() {
        return this.key;
    }

    /**
     * @return this.color
     */
    @Override
    public String getValue() {
        return this.color;
    }


    /**
     * @param value
     * @return
     */
    public String setValue(String value) {
        String oldColor = this.color;
        this.color = value;
        return this.color;
    }


}

