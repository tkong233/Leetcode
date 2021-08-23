package BinarySearch;

import java.util.Random;

public class RandomPickWithWeight {
    int[] prefixSum;

    public RandomPickWithWeight(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = getTarget(prefixSum[0], prefixSum[prefixSum.length - 1]);
        return getSmallestLargerEqual(target);
    }

    // return the index of element in prefixSum that's >= target
    private int getSmallestLargerEqual(int target) {
        int left = 0;
        int right = prefixSum.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int cur = prefixSum[mid];
            if (cur < target) {
                left = mid + 1;
            } else if (cur == target) {
                return mid;
            } else {
                right = mid;
            }
        }
        return (prefixSum[left] >= target) ? left : right;
    }

    // get a random number in [left, right]
    private int getTarget(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    public static void main(String[] args) {
        RandomPickWithWeight solution = new RandomPickWithWeight(new int[] {1, 2, 3, 4});
        int result = solution.pickIndex();
        System.out.println(result);
    }
}
