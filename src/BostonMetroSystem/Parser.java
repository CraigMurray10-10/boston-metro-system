package BostonMetroSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Parser {
    public Parser(){

    }
    public List<String> parseFile(){
        try {
            List<String> stations = Files.readAllLines(Paths.get("bostonmetro"));
            return stations;
        }
        catch(IOException e){
            System.out.println("IO Error");
            e.printStackTrace();
        }
        return null;
    }

    private static Station parseStation(String station){
        //Parse station ID, station name, Neighbours list, etc.
        Station s = new Station();
        return s;
}
}
