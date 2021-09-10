package Trie;
import java.util.*;

public class FindAllWordsWithPrefix {
    class Trie {
        TrieNode root;
        class TrieNode {
            Map<Character, TrieNode> children;
            boolean isWord;
            public TrieNode() {
                children = new HashMap<>();
            }
        }

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode child = cur.children.getOrDefault(character, new TrieNode());
                cur.children.put(character, child);
                cur = child;
            }
            cur.isWord = true;
        }

        public TrieNode findNode(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                TrieNode child = cur.children.getOrDefault(prefix.charAt(i), null);
                if (child == null) {
                    return null;
                }
                cur = child;
            }
            return cur;
        }
    }

    List<String> findWordsWithPrefix(List<String> words, String prefix) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Trie.TrieNode prefixNode = trie.findNode(prefix);
        List<String> result = new ArrayList<>();
        if (prefixNode == null) {
            return null;
        }
        findWordsWithPrefixHelper(prefixNode, new StringBuilder(prefix), result);
        return result;
    }
    
    private void findWordsWithPrefixHelper(Trie.TrieNode node, StringBuilder sb, List<String> result) {
        if (node.isWord) {
            result.add(sb.toString());
        }
        if (node.children == null || node.children.isEmpty()) {
            return;
        }
        for (Map.Entry<Character, Trie.TrieNode> entry : node.children.entrySet()) {
            char character = entry.getKey();
            Trie.TrieNode childNode = entry.getValue();
            sb.append(character);
            findWordsWithPrefixHelper(childNode, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        FindAllWordsWithPrefix solution = new FindAllWordsWithPrefix();
        List<String> result = solution.findWordsWithPrefix(Arrays.asList("abc", "ade", "abg", "abagskdjf", "abi", "ade", "cda", "dea", "dbg", "agj", "aba"), "bdd");
//        List<String> result = solution.findWordsWithPrefix(Arrays.asList("abc", "ade", "agj"), "ab");
        if (result == null) {
            System.out.println("null");
        } else {
            System.out.println(result.toString());
        }
    }
}
