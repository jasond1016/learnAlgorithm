package chapter43_topology;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int n;
    LinkedList<Integer>[] adj;

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);

        graph.topoSortByKahn();
        System.out.println();
        graph.topoSortByDFS();
    }

    public Graph(int n) {
        this.n = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        adj[i].add(j);
    }

    public void topoSortByKahn() {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                inDegree[adj[i].get(j)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.offer(k);
                }
            }
        }
    }

    public void topoSortByDFS() {
        LinkedList<Integer>[] inverseAdj = new LinkedList[n];
        for (int i = 0; i < inverseAdj.length; i++) {
            inverseAdj[i] = new LinkedList<>();
        }

        // 逆邻接表
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }

    }

    private void dfs(int i, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int j = 0; j < inverseAdj[i].size(); j++) {
            int w = inverseAdj[i].get(j);
            if (!visited[w]) {
                visited[w] = true;
                dfs(w, inverseAdj, visited);
            } else {
                continue;
            }
        }
        System.out.print("->" + i);
    }


}
