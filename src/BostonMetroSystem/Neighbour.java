package BostonMetroSystem;

/**
 *
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
     * @return this.line
     */
    public String getColour(){ return this.line; }

    /**
     * @param colour
     */
    public void setColour(String colour){
        this.line = colour;
    }

    /**
     * @return this.first
     */
    public int getFirst(){
        return this.first;
    }

    /**
     * @param first
     */
    public void setFirst(int first){
        this.first = first;
    }

    /**
     * @return
     */
    public int getSecond(){
        return this.second;
    }

    /**
     * @param second
     */
    public void setSecond(int second){
        this.second = second;
    }

}
