package String;

public class ValidPalindromII {
    public class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        Pair pair = findDifference(s);

        if (pair.left >= pair.right) {
            return true;
        }
        return validPalindrome(s.substring(pair.left + 1, pair.right))
                || validPalindrome(s.substring(pair.left, pair.right - 1));
    }

    Pair findDifference(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }

        return new Pair(left, right);
    }

    public static void main(String[] args) {
        ValidPalindromII solution = new ValidPalindromII();
        System.out.println(solution.validPalindrome("abc"));
    }
}
