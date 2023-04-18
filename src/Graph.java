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
        boolean[][] m1 = this.matrix;
        boolean[][] m2 = input.getMatrix();
        if (m1.length != m2.length) return false;
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) return false;
            for (int j = 0; j < m1[i].length; j++) {
                boolean b1 = m1[i][j];
                boolean b2 = m2[i][j];
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

    public boolean isAnyCharRepeated(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) != str.lastIndexOf(c)) {
                return true;
            }
        }
        return false;
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
}
