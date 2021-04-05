package BostonMetroSystem.test;
import BostonMetroSystem.Neighbour;
import BostonMetroSystem.Parser;
import BostonMetroSystem.Station;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests that Parser can successfully read a file and parse the file
 */

public class ParserTest {
    private Parser parser = new Parser();
    private ArrayList<Station> stations;
    private ArrayList<String> info;

    /**
     * Runs same code as readFile with an invalid path, tests if this will throw an exception.
     *
     */
    @Test
    public void readFileTest(){
        //File shouldn't exist
        assertThrows(FileNotFoundException.class,
                () -> {
                    File myObj = new File("src/BostonMetroSystem/test/test.txt");
                    Scanner myReader = new Scanner(myObj);
                    String data = "";
                    this.info = new ArrayList<>();

                    while (myReader.hasNextLine()) {
                        data = myReader.nextLine();
                        this.info.add(data);
                    }

                    myReader.close();
                });
    }

    /**
     * Tests the parsing method to check that it creates objects matching the data successfully.
     *
     */
    @Test
    public void parseFileTest(){
        Station oak = new Station(1, "OakGrove", new ArrayList<>(Arrays.asList(
                new Neighbour("Orange", 0, 2))));
        Station govcentre = new Station(27,"GovernmentCenter", new ArrayList<>(Arrays.asList(
                new Neighbour("Green", 22, 29),
                new Neighbour("Blue", 24, 28))));
        Station kenmore = new Station(47,"Kenmore", new ArrayList<>(Arrays.asList(
                new Neighbour("GreenB", 46, 51),
                new Neighbour("GreenC", 54, 51),
                new Neighbour("GreenD", 57, 51))));
        Station copley = new Station(41,"Copley", new ArrayList<>(Arrays.asList(
                new Neighbour("GreenB", 51, 34),
                new Neighbour("GreenC", 51, 34),
                new Neighbour("GreenD", 51, 34),
                new Neighbour("GreenE", 53, 34))));

        ArrayList<Station> tests = new ArrayList<>(Arrays.asList(oak, govcentre, kenmore, copley));
        this.stations = parser.parseFile("src/BostonMetroSystem/test/test2.txt");
        assertAll(
            //ID and Station Names are the same
                () -> assertEquals(this.stations.get(0).stationAsString(), oak.stationAsString()),
                () -> assertEquals(this.stations.get(1).stationAsString(), govcentre.stationAsString()),
                () -> assertEquals(this.stations.get(2).stationAsString(), kenmore.stationAsString()),
                () -> assertEquals(this.stations.get(3).stationAsString(), copley.stationAsString())
        );
    }
}
