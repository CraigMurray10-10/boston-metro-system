package BostonMetroSystem;

import java.util.ArrayList;

public class RouteFinderController {
    private RouteFinderView theView;
    private RouteFinderModel theModel;

    public RouteFinderController(RouteFinderModel theModel){
        //this.theView = theView;
        this.theModel = theModel;

        //this.theView.init(getStations());
//        this.theView.addCalcRouteListener(new CalculateListener());
    }
    public ArrayList<Station> getStations(){
        return theModel.parseFile();
    }
}
