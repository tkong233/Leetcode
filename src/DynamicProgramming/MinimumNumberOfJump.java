package DynamicProgramming;

public class MinimumNumberOfJump {
        /*
        Given an array of non-negative integers,
        you are initially positioned at the first index of the array,
        each element in the array represents the maximum jump length at the position.
        Calculate the minimum number of jumps from 0 to the last index.
     */

    // return Integer.MAX_VALUE if not possible to reach the last index.
    int minJump(int[] A) {
        // assumptions: A is not null and A.length >= 1
        int[] M = new int[A.length];
        M[0] = 0;
        for (int i = 1; i < M.length; i++) {
            M[i] = -1;
            for (int j = 0; j <= i - 1; j++) {
                if (M[j] != -1 && j + A[j] >= i) {
                    if (M[i] == -1 || (M[j] + 1) < M[i]) {
                        M[i] = M[j] + 1;
                    }
                }
            }
        }
        return M[M.length - 1];
    }

    public static void main(String[] args) {
        MinimumNumberOfJump solution = new MinimumNumberOfJump();
        int result = solution.minJump(new int[] {2, 1, 1, 1, 2});
        System.out.println(result);
    }
}
