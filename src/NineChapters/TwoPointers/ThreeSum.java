package NineChapters.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i <= numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            findUniquePair(numbers, i, result);
        }

        return result;
    }

    void findUniquePair(int[] numbers, int pos, List<List<Integer>> result) {
        int left = pos + 1;
        int right = numbers.length - 1;
        int target = 0 - numbers[pos];
        while (left < right) {
            if (left > pos + 1 && numbers[left] == numbers[left - 1]) {
                left++;
                continue;
            }
            if (right < numbers.length - 1 && numbers[right] == numbers[right + 1]) {
                right--;
                continue;
            }
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result.add(Arrays.asList(numbers[pos], numbers[left], numbers[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> result = solution.threeSum(new int[] {-1,0,1,2,-1,-4});
        for (List l : result) {
            for (Object i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
