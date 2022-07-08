package leetcode.p0797_all_paths_from_source_to_target;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        System.out.println(solution.allPathsSourceTarget(graph));

        graph = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(solution.allPathsSourceTarget(graph));
    }

    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        // 将节点加入路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            // 删除路径最后节点，维护路径正确性
            path.removeLast();
            return;
        }
        
        // 遍历相邻节点
        for (int i : graph[s]) {
            traverse(graph, i, path);
        }

        // 从路径移除节点
        path.removeLast();
    }
}
