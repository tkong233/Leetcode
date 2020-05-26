package DynamicProgramming;

public class LongestAscendingSubarray {
    /*
        Given an unsorted array, find the length of the longest ascending subarray.
     */

    int longestAscendingSubarray(int[] a) {
        if (a == null) {
            return 0;
        }
        if (a.length <= 1) {
            return a.length;
        }
        int longest = 0;
        int cur = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                cur += 1;
                longest = Math.max(cur, longest);
            } else {
                cur = 1;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestAscendingSubarray solution = new LongestAscendingSubarray();
        int result = solution.longestAscendingSubarray(new int[] {1, 2, 3, 2, 1, 4, 5, 6, 7, 3, 4});
        System.out.println(result);
    }
}
