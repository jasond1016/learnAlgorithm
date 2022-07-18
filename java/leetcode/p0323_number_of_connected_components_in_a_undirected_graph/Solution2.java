package leetcode.p0323_number_of_connected_components_in_a_undirected_graph;

public class Solution2 {
    private static class UF {
        // parents[x]是x的父节点
        int[] parents;
        // 连通分量个数
        int count;

        public UF(int n) {
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                // 初始状态下，每个节点的父节点都是自己
                parents[i] = i;
            }
        }

        public void union(int p, int q) {
            // p节点的根节点
            int rootOfP = find(p);
            // q节点的根节点
            int rootOfQ = find(q);
            if (rootOfP == rootOfQ) {
                // 相同说明已连通
                return;
            }
            
            parents[rootOfP] = rootOfQ;
            count--;
        }

        public boolean connected(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            return rootOfP == rootOfQ;
        }

        public int count() {
            return count;
        }

        private int find(int x) {
            // 路径压缩法
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }

    int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] arr : edges) {
            uf.union(arr[0], arr[1]);
        }
        return uf.count();
    }
}
