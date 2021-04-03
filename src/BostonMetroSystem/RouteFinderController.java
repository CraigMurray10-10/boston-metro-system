package BostonMetroSystem;

import javafx.scene.Parent;

import java.util.ArrayList;

public class RouteFinderController {
    private RouteFinderModel theModel;
    private RouteFinderView theView;

    public RouteFinderController(){
        this.theModel = new RouteFinderModel();
        this.theView = new RouteFinderView(theModel.getStations());

    }

    public Parent getParent(){
        return this.theView.asParent();
    }
    public ArrayList<Station> getStations(){
        return theModel.parseFile();
    }
}
