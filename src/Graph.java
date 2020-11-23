import java.util.ArrayList;
import java.util.Collections;
/**
 * graph
 */
public class Graph<T extends Comparable<T>> {
    ArrayList<ArrayList<T>> myList; 
    public T V;
    
    public Vertex<T> start;

    public Graph(T value){
        T V = value;
        myList = new ArrayList<ArrayList<T> >(V);
    }
  
    public Vertex<T> search(T value) {
        
        return new Vertex<T>();
    }

    public void addVertex(Vertex<T> movedIn){
        

    }
    
    public void addEdge(Edge<T> newEdge,Vertex<T> to){
        
    }
    
    public boolean areNeighbors(Vertex<T> A, Vertex<T> B) {
        return true;
    }

    public ArrayList Neighbors(Vertex<T> A) {

        return new ArrayList<T>();
    }
    

    
}