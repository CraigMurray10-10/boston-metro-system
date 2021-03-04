package BostonMetroSystem;

public class MVCRouteFinder {
    public static void main(String[] args){
        RouteFinderView theView = new RouteFinderView();

        RouteFinderModel theModel = new RouteFinderModel();

        RouteFinderController theController = new RouteFinderController(theView, theModel);

        theView.setVisible(true);
    }

        private static List<String> findStations(){
        try {
            List<String> stations = Files.readAllLines(Paths.get("bostonmetro"));
            return stations;
        }
        catch(IOException e){
            System.out.println("IO Error");
            e.printStackTrace();
        }
        return null;
    }
    private static Station parseStation(String station){

        Station station = new Station();
        return station;
    }

}
