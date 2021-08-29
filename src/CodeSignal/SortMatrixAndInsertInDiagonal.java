package CodeSignal;
import java.util.*;

public class SortMatrixAndInsertInDiagonal {
    static class Pair implements Comparable<Pair> {
        int value;
        int frequency;
        public Pair(int v, int f) {
            value = v;
            frequency = f;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value == other.value && this.frequency == other.frequency) {
                return 0;
            }
            if (this.frequency < other.frequency) {
                return -1;
            }
            if (this.frequency > other.frequency) {
                return 1;
            }
            return this.value < other.value ? -1 : 1;
        }
    }
    static int[][] sortMatrix(int[][] matrix) {
        // calculate freq using hash map
        Map<Integer, Integer> valueToFreq = new HashMap<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int value = matrix[row][col];
                int freq = valueToFreq.getOrDefault(value, 0);
                valueToFreq.put(value, freq + 1);
            }
        }
        // sort based on freq & value
        List<Pair> list = new LinkedList<>();
        for (int key : valueToFreq.keySet()) {
            int freq = valueToFreq.get(key);
            list.add(new Pair(key, freq));
        }
        Collections.sort(list);

        // insert in diagonal
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> init = Arrays.asList(rows - 1, cols - 1); // start from bottom right corner
        queue.offer(init);
        Set<List<Integer>> visited = new HashSet<>();
        visited.add(init);
        while (!queue.isEmpty() && list.size() > 0) {
            List<Integer> cur = queue.poll();
            int row = cur.get(0);
            int col = cur.get(1);
            matrix[row][col] = list.remove(0).value;
            List<Integer> left = Arrays.asList(row, col - 1);
            List<Integer> up = Arrays.asList(row - 1, col);
            if (isValid(left, visited, matrix)) {
                queue.offer(left);
                visited.add(left);
            }
            if (isValid(up, visited, matrix)) {
                queue.offer(up);
                visited.add(up);
            }
        }

        return matrix;
    }

    private static boolean isValid(List<Integer> l, Set<List<Integer>> visited, int[][] matrix) {
        if (visited.contains(l)) {
            return false;
        }
        int row = l.get(0);
        int col = l.get(1);
        if (row < 0 || row >= matrix.length) {
            return false;
        }
        if (col < 0 || col >= matrix[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        sortMatrix(new int[][] {
                {0, 1, 2, 3},
                {1, 5, 6, 7},
                {8, 7, 10, 11},
                {12, 13, 14, 15}
        });
    }
}
