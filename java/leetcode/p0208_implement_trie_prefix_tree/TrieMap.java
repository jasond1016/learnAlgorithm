package leetcode.p0208_implement_trie_prefix_tree;

import java.util.ArrayList;
import java.util.List;

public class TrieMap<V> {
    private static final int CAPACITY = 256;
    private int size = 0;
    
    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[CAPACITY];
    }

    private TrieNode<V> root = null;

    public V get(String key) {
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            return null;
        }
        return x.val;
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }

    public boolean hasKeyWithPrefix(String prefix) {
        return getNode(root, prefix) != null;
    }

    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                return query.substring(0, i);
            }
            char c = query.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
            return query;
        }
        return "";
    }

    public String longestPrefixOf(String prefix) {
        TrieNode<V> p = root;
        int maxLen = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (p == null) {
                break;
            }
            if (p.val != null) {
                maxLen = i;
            }
            char c = prefix.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
            return prefix;
        }
        return prefix.substring(0, maxLen);
    }

    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        // 先找到在 Trie 树匹配 prefix 的那个节点
        TrieNode<V> x = getNode(root, prefix);
        if (x == null) {
            return res;
        }
        traverse(x, new StringBuilder(prefix), res);
        return res;
    }

    public List<String> keysWithPattern(String pattern) {
        List<String> res = new ArrayList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    public boolean hasKeyWithPattern(String pattern) {
        return hasKeyWithPattern(root, pattern, 0);
    }

    public void put(String key, V val) {
        if (!containsKey(key)) {
            size++;
        }
        root = put(root, key, val, 0);
    }

    public void remove(String key) {
        if (!containsKey(key)) {
            return;
        }
        root = remove(root, key, 0);
        size--;
    }

    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if (node == null) {
            return null;
        }
        if (i == key.length()) {
            node.val = null;
        } else {
            char c = key.charAt(i);
            node.children[c] = remove(node.children[c], key, i + 1);
        }

        if (node.val != null) {
            return node;
        }

        for (int x = 0; x < CAPACITY; x++) {
            if (node.children[x] != null) {
                return node;
            }
        }
        return null;
    }

    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if (node == null) {
            node = new TrieNode<>();
        }
        if (i == key.length()) {
            node.val = val;
            return node;
        }

        char c = key.charAt(i);
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }

    private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i) {
        if (node == null) {
            return false;
        }
        if (i == pattern.length()) {
            return node.val != null;
        }
        char c = pattern.charAt(i);
        if (c != '.') {
            return hasKeyWithPattern(node.children[c], pattern, i + 1);
        } else {
            for (char j = 0; j < CAPACITY; j++) {
                if (hasKeyWithPattern(node.children[j], pattern, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
        if (node == null) {
            return;
        }
        if (i == pattern.length()) {
            if (node.val != null) {
                res.add(path.toString());
            }
            return;
        }
        char c = pattern.charAt(i);
        if (c == '.') {
            for (char j = 0; j < CAPACITY; j++) {
                path.append(j);
                traverse(node.children[j], path, pattern, i + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            path.append(c);
            traverse(node.children[c], path, pattern, i + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null) {
            return;
        }
        
        if (node.val != null) {
            // 找到一个 key
            res.add(path.toString());
        }

        // 回溯遍历
        for (char c = 0; c < CAPACITY; c++) {
            path.append(c);
            traverse(node.children[c], path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    public int size() {
        return size;
    }

    // 从节点 node 开始搜索 key
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        for (int i = 0; i < key.length(); i++) {
            if (p == null) {
                return null;
            }
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }
}
