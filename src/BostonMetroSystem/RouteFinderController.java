package BostonMetroSystem;

import java.util.ArrayList;

public class RouteFinderController {
    private RouteFinderModel theModel;
    private RouteFinderView theView;

    public RouteFinderController(RouteFinderModel theModel, RouteFinderView theView){
        this.theView = theView;
        this.theModel = theModel;
        theModel.userInputSelectStart(theView.getStartSelectInput());
        theModel.setUserInputSelectEnd(theView.getEndSelectInput());
        theModel.setButtonInput(theView.getButton());
        theView.updateRoutes(theModel.getUpdateRouteListView());

    }
    public ArrayList<Station> getStations(){
        return theModel.parseFile();
    }








}
