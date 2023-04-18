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

    public boolean equals (Graph input) {
        if (this.matrix.length != input.getMatrix().length) return false;
        for (int i = 0; i < this.matrix.length; i++) {
            if (this.matrix[i].length != input.getMatrix()[i].length) return false;
            for (int j = 0; j < this.matrix[i].length; j++) {
                boolean b1 = this.matrix[i][j];
                boolean b2 = input.getMatrix()[i][j];
                if (b1 != b2) return false;
            }
        }
        return true;
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
        matrix[searchVerticeIndex(k1)][searchVerticeIndex(k2)] = true;
        matrix[searchVerticeIndex(k2)][searchVerticeIndex(k1)] = true;
    }

    public boolean hasEdge(char k1, char k2){
        return matrix[searchVerticeIndex(k1)][searchVerticeIndex(k2)];
    }

    public boolean isCircular(String s){
        Graph usedEdges = new Graph(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            usedEdges.addVertice(charList.get(i));
        }
        for (int i = 0; i < s.length()-1; i++) {
            if (!hasEdge(s.charAt(i), s.charAt(i+1)) || usedEdges.hasEdge(s.charAt(i), s.charAt(i+1))){
                return false;
            }
            usedEdges.addEdge(s.charAt(i), s.charAt(i+1));
        }
        return equals(usedEdges);
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public ArrayList<String> allSolutions(){
        ArrayList<String> solutions;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; i < 5; i++) {
                for (int k = 0; i < 5; i++) {
                    for (int l = 0; i < 5; i++) {
                        for (int m = 0; i < 5; i++) {
                            for (int n = 0; i < 5; i++) {
                                for (int o = 0; i < 5; i++) {
                                    for (int p = 0; i < 5; i++) {
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
