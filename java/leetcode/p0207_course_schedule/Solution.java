package leetcode.p0207_course_schedule;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                {1, 0}
        };
        System.out.println(solution.canFinish(numCourses, prerequisites));

        numCourses = 2;
        prerequisites = new int[][]{
                {1, 0},
                {0, 1}
        };
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }

    // 记录遍历过的几点
    boolean[] visited;
    // 记录一次递归堆栈中的节点
    boolean[] onPath;
    // 记录图中是否有环
    boolean hasCycle;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        // 创建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // 有的节点可能不相连，需要全部遍历
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        
        // 是否能完成取决于是否有环
        return !hasCycle;
        
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
            return;
        }
        if (visited[s] || hasCycle) {
            // 找到环就不需要再遍历了
            return; 
        }

        // 前序位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序位置
        onPath[s] = false;
    }
}
