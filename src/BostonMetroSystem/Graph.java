package BostonMetroSystem;
import java.util.*;

public interface Graph<S, P> {
    public void addVertex(S node);
    public void addEdge(S node1, S node2, String edgeDetail);
    public List<P> getAdjVertices(S node);

}

