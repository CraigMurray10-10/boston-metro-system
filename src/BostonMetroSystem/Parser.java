package BostonMetroSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    /**
     * Parser constructor
     */
    public Parser(){

    }

    /**
     * Reads the file in the given filepath or throws an exception. Will return an ArrayList of Strings representing each line in the read file.
     * @param filepath
     * @return stations
     */
    public ArrayList<String> readFile(String filepath) {

        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            String data = "";
            ArrayList<String> stations = new ArrayList();

            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();
                 stations.add(data);
            }

            myReader.close();
            //System.out.println(stations);

            return stations;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Uses readFile to obtain a String populated ArrayList, so that it can parse every line into Station objects.
     * @param filepath
     * @return stations
     */
    public ArrayList<Station> parseFile(String filepath){
        //Get a list of all the stations
        ArrayList<String> parseStation = this.readFile(filepath);
        ArrayList<Station> stations = new ArrayList<>();

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
            allStationInfo = fixString(stringId, allStationInfo);

            //convert id to an int
            int id = Integer.parseInt(stringId);

            //Call parseVal method to parse second val among spaces
            String stationName = parseVal(allStationInfo);
            allStationInfo = fixString(stationName, allStationInfo);
            ArrayList<Neighbour> neighbours = new ArrayList<Neighbour>();

            while (!allStationInfo.equals("")){

                String val = parseVal(allStationInfo);
                allStationInfo = fixString(val, allStationInfo);

                if(!(Character.isDigit(val.charAt(0)))){
                    Neighbour neighbour = new Neighbour("", 0, 0);
                    neighbour.setColour(val);

                    //set first
                    val = parseVal(allStationInfo);
                    neighbour.setFirst(Integer.parseInt(val));
                    allStationInfo = fixString(val, allStationInfo);

                    //set second
                    val = parseVal(allStationInfo);
                    neighbour.setSecond(Integer.parseInt(val));
                    allStationInfo = fixString(val, allStationInfo);
                    neighbours.add(neighbour);
                }
            }
            Station station = new Station(id, stationName, neighbours);
            stations.add(station);
        }
        return stations;
    }


    /**
     * Parses the first found value of a string containing spaces between values.
     * @param stationInfo
     * @return val
     */
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

    /**
     * Erases the first occurrence of a string/value that has just been parsed. The parser can then continue to read the next value.
     * @param val
     * @param allStationInfo
     * @return
     */
    public String fixString(String val, String allStationInfo){
        allStationInfo = allStationInfo.replaceFirst(val, "");
        allStationInfo = allStationInfo.trim();
        return allStationInfo;
    }



}
