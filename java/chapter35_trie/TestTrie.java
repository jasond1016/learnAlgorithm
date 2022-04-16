package chapter35_trie;

public class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("how");
        trie.add("hi");
        trie.add("her");
        trie.add("hello");
        trie.add("so");
        trie.add("see");

        System.out.println(trie.find("hi"));
        System.out.println(trie.find("he"));
        System.out.println(trie.find("boy"));
    }
}
