package Array;

import java.util.Arrays;

public class TwoSumLessThanEqual {
    public int twoSum5(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
                continue;
            }
            result += right - left;
            left++;
        }

        return result;
    }
}
