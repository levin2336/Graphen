public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addVertice('A');
        g.addVertice('B');
        g.addVertice('C');
        g.addVertice('D');
        g.addVertice('E');

        g.addEdge('A','B');
        g.addEdge('A','C');
        g.addEdge('A','E');
        g.addEdge('B','C');
        g.addEdge('B','E');
        g.addEdge('C','D');
        g.addEdge('C','E');
        g.addEdge('D','E');

        System.out.println(g.isCircular("BCDE"));
    }
}