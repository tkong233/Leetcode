package DP;

public class JumpGame {
    /*
        Given an array of non-negative integers,
        you are initially positioned at the first index of the array,
        each element in the array represents the maximum jump length at the position.
        Determine if you are able to reach the last index.
     */
    boolean jumpGame(int[] A) {
        boolean [] M = new boolean[A.length];
        M[A.length - 1] = true;
        for (int i = A.length - 2; i >= 0; i--) {
            boolean cur = false;
            for (int j = i + 1; j <= (i + A[i]); j++) {
                if (M[j] == true) {
                    cur = true;
                }
            }
            M[i] = cur;
        }
        return M[0];
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        boolean result = solution.jumpGame(new int[] {3, 2, 1, 0, 4});
        System.out.println(result);
    }
}
