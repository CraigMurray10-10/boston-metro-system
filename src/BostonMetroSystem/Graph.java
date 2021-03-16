package BostonMetroSystem;
import java.util.*;

public interface Graph<S> {
    public void addVertex(S node);
    public void addEdge(S node1, S node2);
    public List<S> getAdjVertices(S node);

}

