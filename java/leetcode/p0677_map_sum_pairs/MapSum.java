package leetcode.p0677_map_sum_pairs;

import leetcode.p0208_implement_trie_prefix_tree.TrieMap;

import java.util.List;

public class MapSum {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap")); // 3
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap")); // 5
    }

    private TrieMap map;

    public MapSum() {
        map = new TrieMap();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        List<String> keys = map.keysWithPrefix(prefix);
        int res = 0;
        for (String key : keys) {
            res += (int) map.get(key);
        }
        return res;
    }
}
