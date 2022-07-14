package leetcode.p0785_is_graph_bipartite;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {
    public static void main(String[] args) {
        SolutionBFS solution = new SolutionBFS();
        int[][] graph = new int[][]{
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };
        System.out.println(solution.isBipartite(graph));

        graph = new int[][]{
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };
        System.out.println(solution.isBipartite(graph));
    }

    // 记录遍历过的节点
    boolean[] visited;
    // 记录颜色，只有两种
    boolean[] colors;
    // 是否符合二分图性质
    boolean res;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        colors = new boolean[n];
        res = true;

        // 因为图可能不联通，所以需要以每个节点为起点进行遍历
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // bfs 遍历
                bfs(graph, i);
            }
        }
        return res;
    }

    private void bfs(int[][] graph, int i) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.offer(i);

        while (!queue.isEmpty() && res) {
            int cur = queue.poll();

            for (int n : graph[cur]) {
                if (!visited[n]) {
                    // n 节点没有访问过，所以附上和 cur 节点不同的颜色
                    colors[n] = !colors[cur];
                    visited[n] = true;
                    queue.offer(n);
                } else {
                    // n 节点访问过，需要判断 n 和 cur 节点颜色是否不同
                    if (colors[n] == colors[cur]) {
                        res = false;
                    }
                }
            }
            
        }
    }
}
