package CodeSignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlmostEqualNumbersWithOneSwap {
    int almostEqualNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isAlmostEqual(nums[i], nums[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    List<List<Integer>> almostEqualNumbers2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isAlmostEqual(nums[i], nums[j])) {
                    result.add(Arrays.asList(nums[i], nums[j]));
                }
            }
        }
        return result;
    }

    boolean isAlmostEqual(int num1, int num2) {
        char[] one = String.valueOf(num1).toCharArray();
        char[] two = String.valueOf(num2).toCharArray();
        if (one.length != two.length) {
            return false;
        }
        for (int i = 0; i < one.length - 1; i++) {
            if (one[i] == two[i]) {
                continue;
            }
            for (int j = i + 1; j < one.length; j++) {
                swap(two, i, j);
                if (Arrays.equals(one, two)) {
                    return true;
                }
                swap(two, i, j);
            }
            return false;
        }
        return false;
    }

    void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        AlmostEqualNumbersWithOneSwap solution = new AlmostEqualNumbersWithOneSwap();
        List<List<Integer>> result = solution.almostEqualNumbers2(new int[] {1, 23, 156, 1, 1650, 651, 165, 32, 156});
        for (List<Integer> ls : result) {
            for (int i : ls) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
