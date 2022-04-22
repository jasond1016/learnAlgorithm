package chapter35_trie;

public class Trie {
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
    
    private TrieNode root = new TrieNode('/');

    public void add(String s) {
        char[] chars = s.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(chars[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(String s) {
        char[] chars = s.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }

    public class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
