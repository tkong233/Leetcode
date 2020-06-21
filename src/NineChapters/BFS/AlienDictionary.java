package NineChapters.BFS;
import java.util.*;

public class AlienDictionary {


    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = constructGraph(words);
        Map<Character, Integer> inDegree = getInDegree(graph);

        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        char[] result = new char[graph.size()];
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                minHeap.offer(entry.getKey());
            }
        }

        int count = 0;
        while (!minHeap.isEmpty()) {
            int size = minHeap.size();
            List<Character> next = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                char cur = minHeap.poll();
                result[count] = cur;
                count++;

                for (Character neighbor : graph.get(cur)) {
                    int neighborInDegree = inDegree.get(neighbor) - 1;
                    inDegree.put(neighbor, neighborInDegree);
                    if (neighborInDegree == 0) {
                        next.add(neighbor);
                    }
                }
            }

            for (Character nextC : next) {
                minHeap.offer(nextC);
            }
        }

        if (count == result.length)  {
            return new String(result);
        }
        return "";
    }

    Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!graph.containsKey(word.charAt(i))) {
                    graph.put(word.charAt(i), new HashSet<Character>());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                char cur = words[i].charAt(index);
                char next = words[i + 1].charAt(index);
                if (cur != next) {
                    graph.get(cur).add(next);
                    break;
                }
                index++;
            }
        }

        return graph;
    }

    Map<Character, Integer> getInDegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> inDegreeMap = new HashMap<>();
        for (char c : graph.keySet()) {
            inDegreeMap.put(c, 0);
        }

        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            for (Character neighbor : entry.getValue()) {
                inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) + 1);
            }
        }

        return inDegreeMap;
    }

    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();
        String[] words = new String[] {"wrt","wrf","er","ett","rftt"}; // "wertf"
        String result = solution.alienOrder(words);
        System.out.println(result);  // ewrft (wrong)
    }
}
