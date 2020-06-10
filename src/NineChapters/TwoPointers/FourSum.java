package NineChapters.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }

        Arrays.sort(numbers);

        List<Integer> cur = new LinkedList<>();
        for (int one = 0; one <= numbers.length - 4; one++) {
            if (one != 0 && numbers[one] == numbers[one - 1]) {
                continue;
            }
            for (int two = one + 1; two <= numbers.length - 3; two++) {
                if (two != one + 1 && numbers[two] == numbers[two - 1]) {
                    continue;
                }
                cur.add(numbers[one]);
                cur.add(numbers[two]);
                twoSum(numbers, two, target - numbers[one] - numbers[two], result, cur);
                cur.clear();
            }
        }

        return result;
    }

    void twoSum(int[] numbers, int prevPos, int target, List<List<Integer>> result,
                List<Integer> cur) {

        int left = prevPos + 1;
        int right = numbers.length - 1;
        while (left < right) {
            if (left != prevPos + 1 && numbers[left] == numbers[left - 1]) {
                left++;
                continue;
            }
            if (right != numbers.length - 1 && numbers[right] == numbers[right + 1]) {
                right--;
                continue;
            }

            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                cur.add(numbers[left]);
                cur.add(numbers[right]);
                result.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                cur.remove(cur.size() - 1);
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
        FourSum solution = new FourSum();
        List<List<Integer>> result = solution.fourSum(new int[] {1,0,-1,0,-2,2}, 0);
        for (List l : result) {
            for (Object o : l) {
                System.out.print(o + " ");
            }
            System.out.println();
            // Expected [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        }
    }
}
