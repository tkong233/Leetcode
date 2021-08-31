package CodeSignal;
import java.util.*;

public class DiagonalSort {
    private static int[][] diagonalSort(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int rows = result.length;
        int cols = result[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] init = new int[]{0, cols - 1};
        queue.offer(init);
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(init));
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nums = new ArrayList<>();
            List<int[]> positions = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                nums.add(matrix[row][col]);
                positions.add(cur);
                int[] left = new int[] {row, col - 1};
                int[] down = new int[] {row + 1, col};
                if (isValid(left, rows, cols, visited)) {
                    queue.offer(left);
                    visited.add(Arrays.toString(left));
                }
                if (isValid(down, rows, cols, visited)) {
                    queue.offer(down);
                    visited.add(Arrays.toString(down));
                }
            }
            Collections.sort(nums);
            for (int i = 0; i < positions.size(); i++) {
                int[] position = positions.get(i);
                result[position[0]][position[1]] = nums.get(i);
            }
        }
        return result;
    }

    private static boolean isValid(int[] pos, int rows, int cols, Set<String> visited) {
        if (visited.contains(Arrays.toString(pos))) {
            return false;
        }
        int row = pos[0];
        int col = pos[1];
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        diagonalSort(new int[][] {
                {8, 4, 1},
                {4, 4, 1},
                {4, 8, 9}
        });
    }
}
