package leetcode.p0208_implement_trie_prefix_tree;

public class Trie {
    TrieSet set = new TrieSet();

    public Trie() {

    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        return set.hasKeyWithPrefix(prefix);
    }
}
