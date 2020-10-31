package DP;

public class MaxProductCuttingRope {
    /*
        Given a rope with integer-length n,
        how to cut the rope into m integer-length parts with length p[0], p[1]...p[m-1],
        in order to get the maximum product of p[0]*p[1]*...*p[m-1]?
        m must be >= 1.
     */

    // method 1: DFS, Time = O(n!) => O(n^2)
    int maxProduct1(int n) {
        if (n <= 1) {
            return 1;
        }
        int max = 0;
        // i = meters of rope to cut off
        for (int i = 1; i < n; i++) {
            int best = Math.max(n - i, maxProduct1(n - i));
            max = Math.max(max, best * i);
        }
        return max;
    }

    // method 2: DP, 左大段，右大段
    int maxProduct2(int n) {
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= n; i++) {
            int cur = 0;
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                cur = Math.max(j, M[j]) * Math.max(i - j, M[i - j]);
                max = Math.max(cur, max);
            }
            M[i] = max;
        }
        return M[n];
    }

    // method 3: DP, 左大段，右小段(不可再分)
    int maxProduct3(int n) {
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int left = Math.max(j, M[j]);
                int right = i - j;
                max = Math.max(max, left * right);
            }
            M[i] = max;
        }
        return M[n];
    }


    public static void main(String[] args) {
        MaxProductCuttingRope solution = new MaxProductCuttingRope();
        System.out.println(solution.maxProduct3(5));
    }
}
