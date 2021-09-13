package DFS;
import java.util.*;

public class ShuffleNumbers {
    private List<int[]> shuffleNumbers(int n) {
        List<int[]> result = new ArrayList<>();
        helper(n, new int[2 * n], result);
        return result;
    }

    private void helper(int n, int[] array, List<int[]> result) {
        if (n == 0) {
            result.add(array.clone());
            return;
        }
        for (int i = 0; i + n + 1 < array.length; i++) {
            if (array[i] != 0 || array[i + n + 1] != 0) {
                continue;
            }
            array[i] = n;
            array[i + n + 1] = n;
            helper(n - 1, array, result);
            array[i] = 0;
            array[i + n + 1] = 0;
        }
    }

    public static void main(String[] args) {
        ShuffleNumbers solution = new ShuffleNumbers();
        List<int[]> result = solution.shuffleNumbers(3);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}
