import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Graph {

    boolean[][] matrix;
    List<Character> charList;

    public Graph(int anzahl) {
        matrix = new boolean[anzahl][anzahl];
        charList = new ArrayList<>();
    }

    public void addVertice(char k){
        if (charList.size() >= matrix.length){
            throw new ArrayIndexOutOfBoundsException("all Vertices are already set");
        }
        charList.add(k);
    }

    public int searchVerticeIndex(char zeichen) {
        if (!charList.contains(zeichen)){
            throw new ArrayIndexOutOfBoundsException("char not found");
        }
        return charList.indexOf(zeichen);
    }

    public void addEdge(char k1, char k2){

    }

    public boolean hasEdge(char k1, char k2){
        return true;
    }
}
