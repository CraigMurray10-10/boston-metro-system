package BostonMetroSystem;

import java.util.ArrayList;

public class RouteFinderController {
    private RouteFinderView theView;
    private RouteFinderModel theModel;

    public RouteFinderController(RouteFinderView theView, RouteFinderModel theModel){
        this.theView = theView;
        this.theModel = theModel;
        ArrayList<String> stations = theModel.parseFile();


        //this.theView.addCalcRouteListener(new CalculateListener());
    }
}
