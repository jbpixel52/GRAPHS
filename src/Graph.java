import java.util.*;

/*//TODO para que el DFS funcione despues de un remove,
se tiene que restar y quitar -1 al Hashmap de Indexes, para
que no lo viaje el DFS  
*/
public class Graph<T extends Comparable<T>> {
    private int counter = 0;
    HashMap<T, LinkedList<T>> adjList = new HashMap<>();
    HashMap<T, Integer> indexes = new HashMap<>();
    public int index = -1;

    public Graph(ArrayList<T> vertices) {
        for (int i = 0; i < vertices.size(); i++) {
            T vertex = vertices.get(i);
            LinkedList<T> list = new LinkedList<>();
            adjList.put(vertex, list);
            indexes.put(vertex, ++index);
        }
    }

    public int getCounter() {
        return counter;
    }

    public void addCounter() {
        this.counter++;
    }

    public void addEdge(T start, T end) {
        LinkedList<T> list;
        list = adjList.get(start);
        list.addFirst(end);
        adjList.put(start, list);
    }

    public void removeVertex(T vertex) {
        adjList.remove(vertex);
        indexes.remove(vertex);

        Set<T> set = adjList.keySet();
        Iterator<T> iterator = set.iterator();
        // CHINGA TU MADRE NULLPOINTEREXCEPTION
        // FRIEDNSHIP WITH COLLECTIONS & ITERATOR ARE UP 500%

        while (iterator.hasNext()) {
            T v = iterator.next();
            LinkedList<T> list = adjList.get(v);
            for (int i = 0; i < list.size(); i++) {
                if (list.contains(vertex))
                    list.remove(vertex);
            }
        }
    }

    public void DFS() {
        System.out.println("DFS");
        int vertices = adjList.size();
        boolean[] visited = new boolean[vertices];
        for (Map.Entry<T, LinkedList<T>> entry : adjList.entrySet()) {
            T start = entry.getKey();
            if (!visited[indexes.get(start)])
                DFShelper(start, visited);

        }
    }

    public void DFShelper(T start, boolean[] visited) {

        // mark this visited
        visited[indexes.get(start)] = true;

        System.out.print(start + " ");
        LinkedList<T> list = adjList.get(start);
        for (int i = 0; i < list.size(); i++) {
            T end = list.get(i);
            if (!visited[indexes.get(end)])
                DFShelper(end, visited);
        }
    }

    public void printGraph() {
        Set<T> set = adjList.keySet();
        Iterator<T> iterator = set.iterator();

        while (iterator.hasNext()) {
            T vertex = iterator.next();
            System.out.print(vertex + " -> ");
            LinkedList<T> list = adjList.get(vertex);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public void removeAllVertex(T toDelete) {
        // Removes all edeges of said verte
        Set<T> set = adjList.keySet();
        Iterator<T> iterator = set.iterator();

        while (iterator.hasNext()) {
            T vertex = iterator.next();
            if (vertex.compareTo(toDelete) == 0) {
                // System.out.println("VERTEX IS THE ONE TO DELETE!");
                // adjList.remove(toDelete);
            }
            LinkedList<T> list = adjList.get(vertex);
            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                // System.out.println("List Size="+list.size());
                // System.out.println("Nada que hacer");
                if (list.get(i).compareTo(toDelete) == 0) {
                    list.remove(i);
                    this.counter--;
                    listSize = list.size();

                    System.out.println("edge conected to deleted vertex deleted..");
                    // AQUI SE REPONE LA LISTA ACTUALIZADA DESPUES DE CADA DELETE
                    adjList.put(vertex, list);
                    adjList.replace(vertex, list);
                }
            }

        }
    }

    public void removeBoth(T toDelete) {
        // Removes all edges of node and then said node
        removeAllVertex(toDelete);
        this.adjList.remove(toDelete);
    }

    public boolean areTheyNeighbors(T a, T b) {
        // son vecinos? quien sabe no>
        LinkedList<T> aList = adjList.get(a);
        LinkedList<T> bList = adjList.get(b);
        if (aList.contains(b) || bList.contains(a)) {
            System.out.println("si son vecinos!");
            return true;
        } else
            System.out.println("no son vecinos");
        return false;
    }

}