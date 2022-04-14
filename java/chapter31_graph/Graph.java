package chapter31_graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    // 顶点个数
    private int v;

    // 邻接表
    private LinkedList<Integer> adj[];

    private boolean found = false;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() > 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.offer(q);
                }
            }
        }
    }

    public void dfs(int s, int t) {
        found = false;
        if (s == t) {
            return;
        }

        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        recursiveDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recursiveDfs(int s, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        if (s == t) {
            found = true;
            return;
        }
        visited[s] = true;
        for (int i = 0; i < adj[s].size(); i++) {
            int q = adj[s].get(i);
            if (!visited[q]) {
                prev[q] = s;
                visited[q] = true;
                recursiveDfs(q, t, visited, prev);
            }

        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
