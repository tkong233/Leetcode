package Interviews.Intuit;

/*
    输入：

    ["3234.html", "xys.html", "7hsaa.html"] // user1
    ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2

    输出两个user的最长连续且相同的访问记录。

    ["xys.html", "7hsaa.html"]
 */

public class Db_LongestContiguousCommonSubarray {
    String[] longestContiguousCommonSubarray(String[] arr1, String[] arr2) {
        int maxLength = 0;
        int start = 0;

        int[][] dp = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }

                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    start = i - maxLength + 1;
                }
            }
        }

        String[] result = new String[maxLength];
        for (int i = 0; i < maxLength; i++) {
            result[i] = arr1[start + i];
        }

        return result;
    }

    public static void main(String[] args) {
        Db_LongestContiguousCommonSubarray solution = new Db_LongestContiguousCommonSubarray();
        String[] arr1 = new String[] {"3234.html", "xys.html", "7hsaa.html"};
        String[] arr2 = new String[] {"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
        String[] result = solution.longestContiguousCommonSubarray(arr1, arr2);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
