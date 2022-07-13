package leetcode.p0210_course_schedule_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionBFS {
    public static void main(String[] args) {
        SolutionBFS solution = new SolutionBFS();
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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
        // 计算入度
        int[] inDegrees = new int[numCourses];
        for (int[] arr : prerequisites) {
            int to = arr[0];
            inDegrees[to]++;
        }

        // BFS遍历用队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                // 先遍历入度为0的节点
                queue.offer(i);
            } 
        }

        // 记录拓扑排序结果
        int[] res = new int[numCourses];
        // 记录遍历节点个数（索引）
        int count = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            // 队列弹出节点顺序即为拓扑排序结果
            res[count++] = p;
            for (int n : graph[p]) {
                // 依赖弹出节点的其他节点入度减1
                inDegrees[n]--;
                if (inDegrees[n] == 0) {
                    // 入度为0，加入队列
                    queue.offer(n);
                }
            }
        }

        if (count != numCourses) {
            // 存在环，拓扑排序结果不存在
            return new int[]{};
        }

        return res;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] arr : prerequisites) {
            int from = arr[1];
            int to = arr[0];
            graph[from].add(to);
        }

        return graph;
    }
}
