package leetcode.p1584_min_cost_to_connect_all_points;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        };
        System.out.println(solution.minCostConnectPoints(points));

        points = new int[][]{
                {3,12},{-2,5},{-4,1}
        };
        System.out.println(solution.minCostConnectPoints(points));
    }
    private static class UF {
        int count;
        int[] parents;

        public UF(int n) {
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public boolean connected(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            return rootOfP == rootOfQ;
        }
        
        public int count() {
            return count;
        }

        public void union(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            if (rootOfP == rootOfQ) {
                return;
            }

            parents[rootOfP] = rootOfQ;
            count--;
        }

        private int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int res = 0;
        List<int[]> edges = new ArrayList<>();
        // 生成所有边和权重
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                // 可以使用points索引代替point
                edges.add(new int[]{i, j, Math.abs(x1 - x2) + Math.abs(y1 - y2)});
            }
        }

        // 将边按照权重从小到大排序
        edges.sort(Comparator.comparingInt(a -> a[2]));
        
        UF uf = new UF(points.length);
        for (int[] edge : edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            int weight = edge[2];
            // 如果已经相连，再次连接可能产生环，不加入最小生成树中
            if (uf.connected(p1, p2)) {
                continue;
            }

            // 这条边不会产生环，则属于最小生成树
            uf.union(p1, p2);
            res += weight;
        }

        return res;
    }
}
