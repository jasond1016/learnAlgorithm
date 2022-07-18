package leetcode.p0990_satisfiability_of_equality_equations;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] equations = new String[]{
                "a==b",
                "b!=a"
        };
        System.out.println(solution.equationsPossible(equations));

        equations = new String[]{
                "b==a",
                "a==b"
        };
        System.out.println(solution.equationsPossible(equations));
    }
    
    private static class UF {
        int[] parents;
        int count;

        public UF(int n) {
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
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

        public boolean connected(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            return rootOfP == rootOfQ;
        }

        public int count() {
            return count;
        }

        private int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        // 26个英文字母
        UF uf = new UF(26);
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                // 相等就让它们连通
                uf.union(e.charAt(0) - 'a', e.charAt(3) - 'a');
            }
        }

        for (String e : equations) {
            if (e.charAt(1) == '!') {
                // 不等如果还已连通说明无法满足
                if (uf.connected(e.charAt(0) - 'a', e.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
