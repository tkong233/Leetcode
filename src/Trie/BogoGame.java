package Trie;
import java.util.*;

public class BogoGame {
    private static int[] rowDirection = new int[] {1, -1, 0, 0};
    private static int[] colDirection = new int[] {0, 0, -1, 1};

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

        void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode child = cur.children.get(character);
                if (child == null) {
                    child = new TrieNode();
                    cur.children.put(character, child);
                }
                cur = child;
            }
            cur.isWord = true;
        }
    }

    List<String> bogoGame(char[][] matrix, List<String> words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<String> result = new HashSet<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char character = matrix[row][col];
                Trie.TrieNode node = trie.root.children.get(character);
                if (node == null) {
                    continue;
                }
                boolean[][] visited = new boolean[rows][cols];
                visited[row][col] = true;
                findWord(node, new StringBuilder(character + ""), row, col, matrix, result, visited);
            }
        }

        return new ArrayList<>(new HashSet<>(result));
    }

    void findWord(Trie.TrieNode node, StringBuilder sb, int row, int col, char[][] matrix, Set<String> result, boolean[][] visited) {
        if (node == null) { // not node.children.isEmpty() !!!
            return;
        }
        if (node.isWord) {
            result.add(sb.toString());
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDirection[i];
            int newCol = col + colDirection[i];
            if (!isValid(matrix, newRow, newCol, visited)) {
                continue;
            }
            Trie.TrieNode child = node.children.get(matrix[newRow][newCol]);
            if (child == null) {
                continue;
            }
            sb.append(matrix[newRow][newCol]);
            visited[newRow][newCol] = true;
            findWord(child, sb, newRow, newCol, matrix, result, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[newRow][newCol] = false;
        }
    }

    boolean isValid(char[][] matrix, int row, int col, boolean[][] visited) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BogoGame solution = new BogoGame();
        List<String> result = solution.bogoGame(new char[][] {
                {'a', 'p', 'p', 'd'},
                {'p', 'p', 'l', 'g'},
                {'o', 'g', 'e', 'i'},
                {'d', 'k', 'l', 'm'},
        }, Arrays.asList("app", "apple", "dog"));
        System.out.println(result.toString());
    }
}
