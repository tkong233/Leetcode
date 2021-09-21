package Interviews.Google;

public class SplitNumberMinDiff {
    private static int minDiff(int num) {
        // if num < 10 -> return 0
        // 191
        // 10: right = 191 mod 10 -> 1, left = 191 / 10 = 19
        // 100: right = 191 mod 100 -> 91, left = 191 / 100 -> 1
        // 100
        // 10: right = 100 mod 10 -> 0, left = 100 / 10 -> 10
        // 100: right = 100 mod 100 -> 0, left = 100 / 100 -> 1
        if (num < 10) {
            return 0;
        }
        int powerOfTen = 10;
        int minDiff = Integer.MAX_VALUE;
        while (powerOfTen <= num) {
            int left = num / powerOfTen;
            int right = num % powerOfTen;
            minDiff = Math.min(Math.abs(left - right), minDiff);
            powerOfTen *= 10;
        }
        return minDiff;
    }

    public static void main(String[] args) {
        System.out.println(minDiff(191));
    }
}
