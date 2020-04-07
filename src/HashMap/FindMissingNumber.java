package HashMap;

import DFS.FindCombination;

import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
    public int findMissingNumber(int[] array, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i: array) {
            set.add(i);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMissingNumber solution = new FindMissingNumber();
        int result = solution.findMissingNumber(new int[] {1, 4, 3, 5, 6}, 6);
        System.out.println(result);
    }
}
