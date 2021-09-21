package Interviews.Google;

import java.util.Arrays;

public class MinMaxPair {
    public static int minPairSum(int[] A) {
        Arrays.sort(A);
        int res = 0, n = A.length;
        for (int i = 0; i < n / 2; ++i)
            res = Math.max(res, A[i] + A[n - i - 1]);
        return res;
    }

    public static void main(String[] args) {
        int result = minPairSum(new int[] {1, 2, 4, 6});
        System.out.println(result);
    }
}
