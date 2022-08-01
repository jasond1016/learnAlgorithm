package leetcode.p0648_replace_words;

import leetcode.p0208_implement_trie_prefix_tree.TrieSet;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(dictionary, sentence)); // "the cat was rat by the bat"

        dictionary = Arrays.asList("a", "b", "c");
        sentence = "aadsfasf absbs bbab cadsfafs";
        System.out.println(solution.replaceWords(dictionary, sentence)); // "a a b c"

    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieSet set = new TrieSet();
        for (String key : dictionary) {
            set.add(key);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = set.shortestPrefixOf(words[i]);
            if (!prefix.isEmpty()) {
                sb.append(prefix);
            } else {
                sb.append(words[i]);
            }

            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
