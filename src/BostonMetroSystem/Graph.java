package BostonMetroSystem;
import java.util.*;


/**
 * Implements all methods needed to represent a graph. It makes use of abstract data types so types can be changed depending on the system it is being implemented for.
 */
public interface Graph<S, P> {

    /**
     * adds a vertex to the graph.
     *  @param node the vertex to be added to the graph
     *
     */
    public void addVertex(S node);

    /**
     * adds an edge to the graph.
     *  @param  node1 the vertex that for every adjacent vertex an edge has to be added to the graph
     *
     */
    public void addEdge(S node1);

    /**
     * gets adjacent vertices of a given vertex.
     * @param  node the vertex of which neighbouring vertices are wanted
     * @return List<P>
     */
    public List<P> getAdjVertices(S node);

}

