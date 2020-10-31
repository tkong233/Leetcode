package DP;

public class LargestSumOfSubarray {
    /*
        Given an unsorted array, find the subarray that has the largest sum,
        return the sum, left boarder and right boarder.
     */

    int[] largestSumOfSubarray(int[] array) {
        int max = Integer.MIN_VALUE;
        int prevSum = array[0];
        int curLeft = 0;
        int curRight = 1;
        int globalLeft = 0;
        int globalRight = 1;
        for (int i = 1; i < array.length; i++) {
            int curSum;
            if (prevSum + array[i] > array[i]) {
                 curSum = prevSum + array[i];
                curRight++;
            } else {
                curSum = array[i];
                curLeft = i;
                curRight = curLeft + 1;
            }

            if (curSum > max) {
                max = curSum;
                globalLeft = curLeft;
                globalRight = curRight;
            }

            prevSum = curSum;
        }
        return new int[] {max, globalLeft, globalRight};
    }

    public static void main(String args[]) {
        LargestSumOfSubarray solution = new LargestSumOfSubarray();
        int[] result = solution.largestSumOfSubarray(new int[] {-5, 2, 3, 1, 0, -2, 6});
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}
