package BostonMetroSystem;

public class Neighbour {
    private String line;
    private int first;
    private int second;

    public Neighbour(String colour, int first, int second){
        this.line = colour;
        this.first = first;
        this.second = second;
    }

    public String getColour(){
        return this.line;
    }

    public void setColour(String colour){
        this.line = colour;
    }

    public int getFirst(){
        return this.first;
    }

    public void setFirst(int first){
        this.first = first;
    }

    public int getSecond(){
        return this.second;
    }

    public void setSecond(int second){
        this.second = second;
    }

}
