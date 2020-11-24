import java.util.*;
public class App {
    public static void main(String[] args){
        //cls.clearScreen();

        ArrayList<String> vertices = new ArrayList<>();

        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> inside = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
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

        for (int i = 0; i < 50; i++) {
        int SIZE = inside.size();
        Random rndStart = new Random();
        Random rndEnd = new Random();
        String start = inside.get(rndStart.nextInt(SIZE));
        String end = inside.get(rndEnd.nextInt(SIZE));
            
        graph.addEdge(start, end);
        graph.counter++;
    }
    

    graph.printGraph();
    graph.DFS();
    System.out.println("\nN edges:"+String.valueOf(graph.counter));
    }
}
