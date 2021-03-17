package BostonMetroSystem;

public class RouteFinderController {
    private RouteFinderView theView;
    private RouteFinderModel theModel;

    public RouteFinderController(RouteFinderView theView, RouteFinderModel theModel){
        this.theView = theView;
        this.theModel = theModel;

        //this.theView.addCalculateListener(new CalculateListener());
    }
}
