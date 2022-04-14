package chapter31_graph;

public class TestGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.bfs(0, 7);

        Graph graph1 = new Graph(9);
        graph1.addEdge(1,2);
        graph1.addEdge(1,4);
        graph1.addEdge(2,3);
        graph1.addEdge(2,5);
        graph1.addEdge(4,5);
        graph1.addEdge(3,6);
        graph1.addEdge(5,6);
        graph1.addEdge(5,7);
        graph1.addEdge(6,8);
        graph1.addEdge(7,8);
        graph1.dfs(1, 7);
    }

}
