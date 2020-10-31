package Interviews.Duolingo;

public class WaysToSum {
    int waysToSum(int total, int k) {
        int[] ways = new int[1];
        getWaysToSum(total, k, ways);
        return ways[0] % ((int) Math.pow(10, 7) + 7);
    }

    void getWaysToSum(int totalLeft, int cur, int[] ways) {
        if (totalLeft == 0 || cur == 1) {
            ways[0] = (ways[0] + 1) % ((int) Math.pow(10, 7) + 7);
            return;
        }

        for (int i = 0; i <= totalLeft / cur; i++) {
            getWaysToSum(totalLeft - i * cur, cur - 1, ways);
        }
    }

    public static void main(String[] args) {
        WaysToSum solution = new WaysToSum();
        int result = solution.waysToSum(8, 2);
        System.out.println(result);
    }
}
