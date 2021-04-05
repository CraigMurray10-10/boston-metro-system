package BostonMetroSystem;

import javafx.scene.Parent;



public class RouteFinderController {
    private RouteFinderModel theModel;
    private RouteFinderView theView;

    /**
     * RouteFinderController constructor
     */
    public RouteFinderController(){
        this.theModel = new RouteFinderModel();
        this.theView = new RouteFinderView(theModel.getStations());

        theModel.userInputSelectStart(theView.getStartSelectInput());
        theModel.setUserInputSelectEnd(theView.getEndSelectInput());
        theView.searchStartUserInput(theView.getSearchStart(), theView.starts);
        theView.searchEndUserInput(theView.getSearchEnd(), theView.ends);
        theModel.setButtonInput(theView.getButton());
        theView.updateRoutes(theModel.getUpdateRouteListView());

    }

    /**
     * @return
     */
    public Parent getParent() { return this.theView.asParent(); }
}
