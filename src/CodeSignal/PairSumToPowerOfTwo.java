package CodeSignal;
import java.util.*;

public class PairSumToPowerOfTwo {
    private static int pairSumToPowerOfTwo(int[] nums) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            int freq = numToFreq.getOrDefault(nums[i], 0);
            numToFreq.put(nums[i], freq + 1);
        }
        Set<Integer> powers = new HashSet<>();
        int power = 1;
        while (power <= max) {
            powers.add(power);
            power *= 2;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // cur + other = p
            for (int p : powers) {
                result += numToFreq.getOrDefault(p - cur, 0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        pairSumToPowerOfTwo(new int[] {1, -1, 2, 3});
    }
}
