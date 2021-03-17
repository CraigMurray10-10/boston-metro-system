package BostonMetroSystem;

import java.util.*;

public class RouteCalculator {

    private MetroGraph metroSystem;
    public RouteCalculator(MetroGraph graph){
        this.metroSystem = graph;

    }

    public List<Station> calculateRoute(Station source, Station destination){
        int count = 0;
        List<List<Station>> agenda = new ArrayList<>();
        agenda.add(new ArrayList<>(Arrays.asList(source)));

        //count is hard coded limit - used number of stations as would assume this would be longest
        //route length possible
        while (!agenda.isEmpty() && count < 125) {
            List<Station> currentPath = agenda.get(0);
            Station currentNode = currentPath.get(currentPath.size() - 1);
            count +=1;
            agenda.remove(currentPath);

            if (destination == currentNode) {
                return currentPath;
            }else{
                List<StationColorPair> nextStatesPairs = metroSystem.getAdjVertices(currentNode);

                //adds all stations to agenda
                for(int i = 0; i < nextStatesPairs.size(); i++){
                    List<Station> tempPath = new ArrayList<Station>();
                    tempPath.addAll(currentPath);
                    tempPath.add(nextStatesPairs.get(i).getKey());
                    agenda.add(tempPath);
                }
            }
        }
        return null;
    }
}
