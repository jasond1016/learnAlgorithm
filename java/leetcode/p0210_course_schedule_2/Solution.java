package leetcode.p0210_course_schedule_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                {1,0}
        };
        System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));

        numCourses = 4;
        prerequisites = new int[][]{
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));

        numCourses = 1;
        prerequisites = new int[][]{};
        System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));
    }

    // 记录遍历过的节点
    boolean[] visited;
    // 记录一次递归栈中的节点
    boolean[] onPath;
    // 是否有环
    boolean hasCycle;
    
    // 后序遍历结果
    List<Integer> path;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        path = new LinkedList<>();
        // 建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        
        if (hasCycle) {
            // 有环
            return new int[]{};
        }

        // 逆后序遍历结果即为拓扑排序结果
        Collections.reverse(path);

        int[] res = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            res[i] = path.get(i);
        }
        return res;
    }

    // 图遍历方法
    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
            return;
        }
        
        if (visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for (int n : graph[s]) {
            traverse(graph, n);
        }
        
        path.add(s);
        onPath[s] = false;
    }
    
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] res = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = new LinkedList<>();
        }

        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            res[from].add(to);
        }

        return res;
    }
}
