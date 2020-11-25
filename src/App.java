import java.util.*;
public class App {
    public static void main(String[] args){
        cls.clearScreen();

        ArrayList<String> vertices = new ArrayList<>();

        final String ALPHABET = "abcde";
        ArrayList<String> inside = new ArrayList<>();
        for (int i = 0; i <3; i++) {
            Random rnd = new Random();
            String s = String.valueOf(ALPHABET.charAt(rnd.nextInt(ALPHABET.length())));    
            
            if (inside.contains(s)) {
                i--;

            }else{
                //vertices.add(s);
                //inside.add(s);
            }
        }
        vertices.add("a");
        vertices.add("b");
        vertices.add("c");
        vertices.add("d");
        vertices.add("e");
        inside.add("a");
        inside.add("b");
        inside.add("c");
        inside.add("d");
        inside.add("e");

        //INICIALIZAMOS EL ARRAY DESPUES DE CREAR LA LISTA DE VERTICES
        Graph<String> graph = new Graph<>(vertices);


        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.addEdge("a", "d");
        graph.addEdge("b", "c");
        graph.addEdge("b", "d");
        graph.addEdge("c", "d");

        int size = inside.size();
        for (int i = 0; i<6; i++) {
        Random rndStart = new Random();
        Random rndEnd = new Random();
        String start = inside.get(rndStart.nextInt(size));
        String end = inside.get(rndEnd.nextInt(size));
        //para evitar loop en uno mismo
        if(!start.equals(end)) {
            //graph.addEdge(start, end);
            //graph.addCounter();;
        }
        
        else{
            //i--;
        }

    }
    graph.printGraph();
    //graph.DFS();
    //graph.removeVertex("p");
    //System.out.println("\n-----\n");
    graph.DFS();
    System.out.println("\n-----\n");
    //graph.printGraph();
    System.out.println("N edges:"+String.valueOf(graph.getCounter()));

    graph.removeBoth("a");
    graph.printGraph();
    graph.DFS();

    graph.areTheyNeighbors("e", "b");
}

}
