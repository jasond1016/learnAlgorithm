package leetcode.p0785_is_graph_bipartite;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
    
    // 记录节点是否遍历过
    boolean[] visited;
    // 颜色只分两种
    boolean[] colors;
    // 是否是二分图
    boolean isBipartite;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        colors = new boolean[n];
        isBipartite = true;

        // 图不一定是连通的，所以需要把每个节点作为起点进行遍历
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return isBipartite;
    }
    
    private void traverse(int[][] graph, int n) {
        // 如果不是二分图停止递归
        if (!isBipartite) {
            return;
        }
        visited[n] = true;
        for (int i : graph[n]) {
            if (!visited[i]) {
                // 相邻节点 i 没有被访问过，所以需要附上和 n 不同的颜色
                colors[i] = !colors[n];
                // 继续遍历 i
                traverse(graph, i);
            } else {
                // 相邻节点被访问过，需要判断相邻颜色是否不同
                if (colors[i] == colors[n]) {
                    // 相同则不是二分图
                    isBipartite = false;
                }
            }
        }
    }
}
