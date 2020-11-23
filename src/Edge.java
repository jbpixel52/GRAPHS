/**
 * Edge
 */

 public class Edge<T> {

    Vertex<T> start;
    Vertex<T> end;
    
    public Edge(Vertex<T> start, Vertex<T> end) {
        this.start = start;
        this.end = end;
    }
}