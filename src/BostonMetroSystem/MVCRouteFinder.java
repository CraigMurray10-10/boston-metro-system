package BostonMetroSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MVCRouteFinder {
    public static void main(String[] args){
        RouteFinderView theView = new RouteFinderView();
/*
        RouteFinderModel theModel = new RouteFinderModel();

        RouteFinderController theController = new RouteFinderController(theView, theModel);

        theView.setVisible(true);*/

        Parser parse = new Parser();

        //parse.readFile();
        parse.parseFile();

    }
}
