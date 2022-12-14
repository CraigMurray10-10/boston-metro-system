package BostonMetroSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Used to search a given graph for a specified route
 */
public class RouteCalculator {


    /**
     * creates initial empty object
     */
    public RouteCalculator(){

    }

    /**
     * Searches given graph for a route between two vertices
     * @param graph the graph to be searched
     * @param source the starting node to begin the search from
     * @param destination the goal node
     * @return currentPath
     */
    public List<Station> findRoute(Graph graph, Station source, Station destination){
        //agenda - will store paths which is why it is a List of Lists.
        Map<List<Station>, Integer> agenda = new HashMap<>();
        //adds source first (as a single element array list) in to the agenda
        agenda.put(new ArrayList<>(Arrays.asList(source)), 0);

        //making the assumption the path will not be more than 125
        //-the hard coded limit can probably be removed when gui sends calue in
        //as user will not be able to input stations that are not part of the system

        int count = 0;

        List<Station> visited = new ArrayList<>();
        while (!agenda.isEmpty()) {
            //get first item in agenda to search
            List<Station> currentPath = this.getBestRoute(agenda);
            //gets stationid of last node in path (i.e. node to be expanded)
            Station currentNode = currentPath.get(currentPath.size() - 1);
            count += 1;

            agenda.remove(currentPath);

            if (currentNode.getID() == destination.getID()) {
                return currentPath;
            } else {
                List<StationColourPair> nextStatePairs = graph.getAdjVertices(currentNode);

                if (nextStatePairs != null) {
                    for (int i = 0; i < nextStatePairs.size(); i++) {
                        if(!visited.contains(nextStatePairs.get(i).getKey())) {
                            List<Station> tempPath = new ArrayList<>();
                            tempPath.addAll(currentPath);
                            tempPath.add(nextStatePairs.get(i).getKey());
                            //weight of the route will be 2* the route size and total switches
                            //this is so the route size is a bigger factor of the weight - it will not be
                            //overriden by a route on a single line.
                            agenda.put(tempPath, (this.calculateLineSwitches(tempPath, graph) + tempPath.size() * 2));
                            visited.add(currentNode);
                        }
                    }
                }

            }

        }
        return null;
    }


    /**
     * Calculates number of line switches occuring in a given route from a given graph
     * @param route the route of which line switches are being calculated from
     * @param graph the graph which contains said route
     * @return int
     */
    //this method loops through route & calculates how many line switches occur so this can then get mapped
    //in the calculate route method
    public int calculateLineSwitches(List<Station> route, Graph graph){

        int totalSwitches = 0;
        String currentLineColour = null;

        for (int i = 0; i < route.size() - 1; i++){

            //use graoh to get adjacent vertices of current note being looked at.
            List<StationColourPair> neighboursCurrent = graph.getAdjVertices(route.get(i));

            //gets next node in route so know when we have the right node to check line colour
            String nextLineColour = null;
            Station nextNode = route.get(i + 1);
            //Use neighbours info to check if starting new line.
            for(int j = 0; j < neighboursCurrent.size(); j++){
                if (neighboursCurrent.get(j).getKey().getID() == nextNode.getID()){
                    //gets line colour to get to next node
                    nextLineColour = neighboursCurrent.get(j).getValue();
                }
            }

            //increments total switches if different
            if (currentLineColour  != null && nextLineColour != null) {
                if (!currentLineColour.equals(nextLineColour)) {
                    totalSwitches++;
                }

            }
            currentLineColour = nextLineColour;
        }

        return totalSwitches;
    }


    /**
     * takes queue and returns route within the queue that has the smallest weight associated
     * @param agenda the queue that is being used in search
     * @return bestRoute
     */
    //used to return route with lowest weight in agenda.
    public List<Station> getBestRoute( Map<List<Station>, Integer> agenda){

        List<Station> bestRoute = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;

        for(List<Station> key: agenda.keySet()){
            if (agenda.get(key) < minValue){
                minValue = agenda.get(key);
                bestRoute = key;
            }
        }
        return bestRoute;
    }
}

