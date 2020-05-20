package String;

public class LongestSubstringWithFlip {
    /*
        Given a string consists of 0's and 1's,
        you can fliat most k 0's to 1's.
        Find the longest substring that consists of all 1's.
     */

    int longestSubstringWithFlip(String str, int maxFlip) {
        int longest = 0;
        char[] a = str.toCharArray();
        int s = 0, f = 0;
        int flipped = 0;
        while (f < a.length) {
            if (a[f] == '1') {
                f++;
                longest = Math.max(f - s, longest);
            } else if (flipped < maxFlip) {
                    flipped++;
                    longest = Math.max(++f - s, longest);
                } else if (a[s++] == '0') {
                        flipped--;
                    }
                }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithFlip solution = new LongestSubstringWithFlip();
        System.out.println(solution.longestSubstringWithFlip("0011100", 2));
    }
}
