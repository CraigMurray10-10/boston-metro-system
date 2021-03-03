package BostonMetroSystem;
import java.util.*;

public interface Graph {
    HashMap <Integer, String> graphNodes = new HashMap<>();
    ArrayList<String> edgeList = new ArrayList<>();
    Set<Integer> vertexSet = graphNodes.keySet();

    public void addVertex(int node);
    public void addEdge(int node1, int node2, String edge);
    public List<HashMap<Integer, String>> neighbours(int node);

}

