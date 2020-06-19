package NineChapters.BFS;
import java.sql.Wrapper;
import java.util.*;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        dict.remove(start);
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> neighbors = getNeighborsAndRemove(cur, dict);
                for (String n : neighbors) {
                    if (n.equals(end)) {
                        return step;
                    }
                    queue.offer(n);
                }
            }
        }

        return 0;
    }

    String replace(String str, int index, int c) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index, (char) c);
        return sb.toString();
    }

    List<String> getNeighborsAndRemove(String str, Set<String> dict) {
        List<String> neighbors = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int c = 'a'; c <= 'z'; c++) {
                String newStr = replace(str, i, c);
                if (dict.contains(newStr)) {
                    neighbors.add(newStr);
                    dict.remove(newStr);
                }
            }
        }

        return neighbors;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        Set<String> dict = new HashSet<>(Arrays.asList(new String[] {"hot","dot","dog","lot","log"}));
        int result = solution.ladderLength("hit", "cog", dict);
//        Set<String> dict2 = new HashSet<>(Arrays.asList(new String[] {"a", "b", "c"}));
//        int result2 = solution.ladderLength("a", "c", dict);
//        System.out.println(result2);
        System.out.println(result);
    }
}
