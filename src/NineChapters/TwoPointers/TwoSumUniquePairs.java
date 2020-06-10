package NineChapters.TwoPointers;

import java.util.Arrays;

public class TwoSumUniquePairs {
    /*
    Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.
     */

    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (left > 0  && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right--;
                continue;
            }
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
