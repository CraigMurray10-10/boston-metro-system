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
            }

            myReader.close();
            System.out.println(stations);

            return stations;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Station> parseFile(){
        //Get a list of all the stations
        ArrayList<String> parseStation = this.readFile();
        ArrayList<Station> stations = new ArrayList<Station>();

        //loop for every station
        for(int i = 0; i < parseStation.size(); i++) {

            //String containing each individual station's info
            String allStationInfo = parseStation.get(i);

            //Removing spaces from the start and the end of each station's info
            allStationInfo  = allStationInfo.trim();

            //Keep the id as a string
            String stringId = "";

            //Call parseVal method to parse first val among spaces
            stringId = parseVal(allStationInfo);
            allStationInfo = allStationInfo.replaceFirst(stringId, "");

            //convert id to an int
            int id = Integer.parseInt(stringId);
            System.out.println(id);
            allStationInfo = allStationInfo.trim();

            //Call parseVal method to parse second val among spaces
            String stationName = parseVal(allStationInfo);
            allStationInfo = allStationInfo.replaceFirst(stationName, "");
            allStationInfo = allStationInfo.trim();
            ArrayList<Neighbour> neighbours = new ArrayList<Neighbour>();
            Neighbour neighbour = new Neighbour("", 0, 0);

            while (!allStationInfo.equals("")){

                String val = parseVal(allStationInfo);
                allStationInfo = allStationInfo.replaceFirst(val, "");
                allStationInfo = allStationInfo.trim();

                if(!(Character.isDigit(val.charAt(0)))){
                    //must be line colour
                    neighbour.setColour(val);
                } else {
                    //must be neighbour station
                    //set first
                    neighbour.setFirst(Integer.parseInt(val));
                    allStationInfo = allStationInfo.trim();

                    //set second
                    val = parseVal(allStationInfo);
                    allStationInfo = allStationInfo.replaceFirst(val, "");
                    allStationInfo = allStationInfo.trim();
                    neighbour.setSecond(Integer.parseInt(val));
                    allStationInfo = allStationInfo.trim();
                    neighbours.add(neighbour);
                }
            }
            Station station = new Station(id, stationName, neighbours);
            stations.add(station);
        }
            return stations;
    }


    public String parseVal(String stationInfo){
        String val = "";
        for(char c: stationInfo.toCharArray()){
            if(c == ' ') {
                break;
            }
            else{
                val += String.valueOf(c);
            }
        }
        return val;
    }




    /*
    private static Station parseStation(String station){
        //Parse station ID, station name, Neighbours list, etc.
        Station s = new Station();
        return s;
}

     */
}
