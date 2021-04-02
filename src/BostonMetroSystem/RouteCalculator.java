package BostonMetroSystem;

import java.util.*;

public class RouteCalculator {


    public RouteCalculator(){

    }


    //TODO: Make changes to method so takes line colour into account
    public List<Station> findRoute(Graph graph, Station source, Station destination){
        ArrayList<Station> route = new ArrayList<>();

        //agenda - will store paths which is why it is a List of Lists.
        List<List<Station>> agenda = new ArrayList<>();
        //adds source first (as a single element array list) in to the agenda
        agenda.add(new ArrayList<>(Arrays.asList(source)));

        //making the assumption the path will not be more than 125
        //-the hard coded limit can probably be removed when gui sends calue in
        //as user will not be able to input stations that are not part of the system

        int count = 0;

        List<Station> visited = new ArrayList<>();
        while (!agenda.isEmpty() && count < 125) {
            //get first item in agenda to search
            List<Station> currentPath = agenda.get(0);
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
                            agenda.add(tempPath);
                            visited.add(nextStatePairs.get(i).getKey());
                        }
                    }
                }

            }

        }
        return null;
    }



}

