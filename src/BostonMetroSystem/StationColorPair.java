package BostonMetroSystem;

import java.util.Map;

public class StationColorPair implements Map.Entry<Station,String>{
    private Station key;
    private String color;

    public StationColorPair(Station key, String color){
        this.key = key;
        this.color = color;
    }
    @Override
    public Station getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.color;
    }

    @Override
    public String setValue(String value) {
        String oldColor = this.color;
        this.color = value;
        return this.color;
    }


}
