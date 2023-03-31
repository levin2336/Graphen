import java.util.ArrayList;
import java.util.List;

public class Graph {

    boolean[][] matrix;
    List<Character> charList;

    public Graph(int anzahl) {
        matrix = new boolean[anzahl][anzahl];
        charList = new ArrayList<>();
    }

    public void addVertice(char k){
        if (charList.size() >= matrix.length){
            return;
        }
        charList.add(k);
    }

    public int searchVericeIndex(char zeichen){
        return 0;
    }

    public void addEdge(char k1, char k2){
        matrix[searchVericeIndex(k1)][searchVericeIndex(k2)] = true;
    }

    public boolean hasEdge(char k1, char k2){
        return matrix[searchVericeIndex(k1)][searchVericeIndex(k2)];
    }
}
