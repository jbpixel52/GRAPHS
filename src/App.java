import java.util.*;
public class App {
    public static void main(String[] args){
        cls.clearScreen();

        ArrayList<String> vertices = new ArrayList<>();

        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> inside = new ArrayList<>();
        for (int i = 0; i <15; i++) {
            Random rnd = new Random();
            String s = String.valueOf(ALPHABET.charAt(rnd.nextInt(ALPHABET.length())));    
            
            if (inside.contains(s)) {
                i--;
            }else{
                vertices.add(s);
                inside.add(s);
            }
        }
        //INICIALIZAMOS EL ARRAY DESPUES DE CREAR LA LISTA DE VERTICES
        Graph graph = new Graph(vertices);

        int SIZE = inside.size();
        for (int i = 0; i<10; i++) {
        Random rndStart = new Random();
        Random rndEnd = new Random();
        String start = inside.get(rndStart.nextInt(SIZE));
        String end = inside.get(rndEnd.nextInt(SIZE));
        //para evitar loop en uno mismo
        if(!start.equals(end)) {
            graph.addEdge(start, end);
            graph.counter++;
        }
        
        else{
            i--;
        }

    }
    

    graph.printGraph();
    graph.DFS();
    //graph.removeVertex("p");
    //System.out.println("\n-----\n");
    //graph.DFS();
    System.out.println("\n-----\n");
    //graph.printGraph();
    System.out.println("\nN edges:"+String.valueOf(graph.counter));
    }
}
