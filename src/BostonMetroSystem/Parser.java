package BostonMetroSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Parser {
    public Parser(){

    }

    public ArrayList<String> readFile() {
        try {
            File myObj = new File("src/BostonMetroSystem/test.txt");
            Scanner myReader = new Scanner(myObj);
            String data = "";
            ArrayList<String> stations = new ArrayList();
            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();
                 stations.add(data);
//            List<String> stations = Files.readAllLines(Paths.get("bostonmetro(1).txt"));
//            System.out.println(stations);
            }
            myReader.close();
            System.out.println(stations);
            return stations;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

        public ArrayList<String> parseFile(){
        //Get a list of all the stations
        ArrayList<String> parseStation = this.readFile();

        //loop for every station
        for(int i = 0; i < parseStation.size(); i++) {

            //String containing each individual station's info
            String allStationInfo = parseStation.get(i);

            //Removing spaces from the start and the end of each station's info
            allStationInfo  = allStationInfo.trim();


            //Keep the id as a string
            String stringId = "";

            //For loop that basically adds everything before the first space to stringId
           for(char c: allStationInfo.toCharArray()){
               if(c != ' ') {
                   stringId += c;

               }
               else{
                   break;
               }
           }
            //convert id to an int
            int id = Integer.parseInt(stringId);
            System.out.println( id);
        }
            return parseStation;
    }






    /*
    private static Station parseStation(String station){
        //Parse station ID, station name, Neighbours list, etc.
        Station s = new Station();
        return s;
}

     */
}
