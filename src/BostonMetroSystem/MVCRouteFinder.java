package BostonMetroSystem;

import java.util.List;

public class MVCRouteFinder {
    public static void main(String[] args){
        RouteFinderModel theModel = new RouteFinderModel();
        RouteFinderView theView = new RouteFinderView();
        RouteFinderController theController = new RouteFinderController(theView, theModel);
    }
}
