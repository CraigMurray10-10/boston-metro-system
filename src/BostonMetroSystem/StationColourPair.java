package BostonMetroSystem;


/**
 * Implements the pair class to represent adjacent stations and the line colour of the edge between.
 */
public class StationColourPair implements Pair<Station,String>{
    private Station key;
    private String color;

    /**
     * creates class object
     * @param key a station adjacent to a vertex
     * @param color the colour of the line between the two vertices.
     */
    public StationColourPair(Station key, String color){
        this.key = key;
        this.color = color;
    }

    /**
     * returns the station object associated with this
     * @return this.key
     */
    @Override
    public Station getKey() {
        return this.key;
    }

    /**
     * returns the color of the line associated with this
     * @return this.color
     */
    @Override
    public String getValue() {
        return this.color;
    }



}

