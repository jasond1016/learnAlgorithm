package leetcode.p0207_course_schedule;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionBFS {
    public static void main(String[] args) {
        SolutionBFS solution = new SolutionBFS();
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // 记录所有节点的入度
        int[] inDegrees = new int[numCourses];
        for (int[] arr : prerequisites) {
            int to = arr[0];
            inDegrees[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 先遍历所有入度等于 0 的
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录遍历过的节点个数
        int count = 0;
        while (!queue.isEmpty()) {
            // 从队列中取出节点
            int p = queue.poll();
            count++;
            for (int n : graph[p]) {
                // 所有依赖该节点的入度减1
                inDegrees[n]--;
                if (inDegrees[n] == 0) {
                    // 如果入度降为 0 则加入队列
                    queue.offer(n);
                }
            }
        }

        // 所有节点都遍历到则无环，否则有环
        return count == numCourses;
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
