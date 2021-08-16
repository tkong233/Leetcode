package Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddAndSearchWord {
    private static final int ALPHABET_SIZE = 26;
    private TrieNode root;
    private class TrieNode {
        TrieNode[] children;
        boolean isCompleteWord;

        private TrieNode() {
            this.children = new TrieNode[ALPHABET_SIZE];
        }
    }


    /** Initialize your data structure here. */
    public AddAndSearchWord () {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isCompleteWord = true;
    }

    public boolean search(String word) {
        return match(word, 0, root);
    }

    private boolean match(String word, int i, TrieNode cur) {
        if (i == word.length() && !cur.isCompleteWord) {
            return false;
        } else if (i == word.length()) {
            return true;
        }
        char character = word.charAt(i);
        if (character != '.') {
            TrieNode child = cur.children[character - 'a'];
            return child != null && match(word, i + 1, child);
        } else {
            for (TrieNode child : cur.children) {
                if (child != null && match(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("bob", "dog", "love", "dig", "amazing");
        AddAndSearchWord solution = new AddAndSearchWord();
        for (String word : dict) {
            solution.addWord(word);
        }
        boolean result = solution.search("a.azing");
        System.out.println(result);
    }
}
