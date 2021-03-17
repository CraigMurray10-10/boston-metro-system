package BostonMetroSystem;

import java.util.*;

public class RouteCalculator {

    private MetroGraph metroSystem;
    public RouteCalculator(MetroGraph graph){
        this.metroSystem = graph;

    }

    public Boolean calculateRoute(Station source, Station destination){
        int count = 0;
        List<Station> agenda = new ArrayList<>();
        agenda.add(source);

        //count is hard coded limit - used number of stations as would assume this would be longest
        //route length possible
        while (!agenda.isEmpty() && count < 125) {
            Station current = agenda.get(0);
            count +=1;
            agenda.remove(current);

            if (destination == current) {
                return true;
            }else{
                List<StationColorPair> nextStatesPairs = metroSystem.getAdjVertices(current);

                //adds all stations to agenda
                for(int i = 0; i < nextStatesPairs.size(); i++){
                    agenda.add(nextStatesPairs.get(i).getKey());
                }
            }
        }
        return false;
    }
}
