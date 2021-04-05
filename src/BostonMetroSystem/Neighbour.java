package BostonMetroSystem;

/**
 * Used to represent neighbouring stations to each station object.
 * Contains the line colour of which the neighbouring stations are on, along with the 'station before' neighbour (first) and 'station after' neighbour (second).
 */
public class Neighbour {
    private String line;
    private int first;
    private int second;

    /**
     * Neighbour constructor
     * @param colour
     * @param first
     * @param second
     */
    public Neighbour(String colour, int first, int second){
        this.line = colour;
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the colour of a line
     * @return this.line
     *
     */
    public String getColour(){ return this.line; }

    /**
     * Sets the colour of a line
     * @param colour
     *
     */
    public void setColour(String colour){
        this.line = colour;
    }

    /**
     * Gets the first neighbour of a line
     * @return this.first
     *
     */
    public int getFirst(){
        return this.first;
    }

    /**
     * Sets the first neighbour of a line
     * @param first
     *
     */
    public void setFirst(int first){
        this.first = first;
    }

    /**
     * Gets the second neighbour of a line
     * @return
     *
     */
    public int getSecond(){
        return this.second;
    }

    /**
     * Sets the second neighbour of a line
     * @param second
     *
     */
    public void setSecond(int second){
        this.second = second;
    }

}
