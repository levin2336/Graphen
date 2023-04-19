import java.util.ArrayList;
import java.util.List;

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

    public String intToString(int input){
        return switch (input) {
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "D";
            case 4 -> "E";
            default -> "X";
        };
    }

    public ArrayList<String> allSolutions(){
        String Current;
        ArrayList<String> solutions = new ArrayList<>();
        //int counter = 0;


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        for (int m = 0; m < 5; m++) {
                            for (int n = 0; n < 5; n++) {
                                for (int o = 0; o < 5; o++) {
                                    for (int p = 0; p < 5; p++) {
                                        for (int q = 0; q < 5; q++) {
                                            Current = (intToString(i)+intToString(j)+intToString(k)+intToString(l)+intToString(m)+intToString(n)+intToString(o)+intToString(p)+intToString(q));

                                            if(isCircular(Current)){
                                                solutions.add(Current);
                                                //counter++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //System.out.println(counter);
        return solutions;
    }
}
