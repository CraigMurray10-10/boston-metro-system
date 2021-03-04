package BostonMetroSystem;

public class MVCRouteFinder {
    public static void main(String[] args){
        RouteFinderView theView = new RouteFinderView();

        RouteFinderModel theModel = new RouteFinderModel();

        RouteFinderController theController = new RouteFinderController(theView, theModel);

        theView.setVisible(true);
    }

}
