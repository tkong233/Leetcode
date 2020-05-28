package String;

public class LongestPalindromicSubstring {
    String longestPalindromicSubstring(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        String longest = "";

        for (int i = 1; i < input.length(); i++) {
            // even
            String even = getPalindrom(i-1, i, input);
            if (even.length() > longest.length()) {
                longest = even;
            }

            // odd
            String odd = getPalindrom(i, i, input);
            if (odd.length() > longest.length()) {
                longest = odd;
            }
        }
        return longest;
    }

    String getPalindrom(int left, int right, String input) {
        while (left >= 0 && right < input.length()) {
            if (input.charAt(left) != input.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return input.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String result = solution.longestPalindromicSubstring("abcb");
        System.out.println(result);
    }
}
