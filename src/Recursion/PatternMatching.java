package Recursion;

public class PatternMatching {
    /*
        A word such as "book" can be abbreviated to 4, 101k, b3, b2k, etc.
        Given a string and an abbreviation, return if the string matches the abbreviation.
     */

    boolean matchPattern(String string, String pattern) {
        // assumptions: string and pattern are not null
        char[] str = string.toCharArray();
        char[] pat = pattern.toCharArray();
        int s = 0;
        int p = 0;
        while ((s < str.length) && (p < pat.length)) {
            // case 1: pat[p] is a digit
            if (isDigit(pat[p])) {
                int sum = pat[p] - '0';
                p++;
                while (p < pat.length && isDigit(pat[p])) {
                    sum *= 10;
                    sum += pat[p] - '0';
                    p++;
                }
                if (str.length - s  >= sum) {
                    s+= sum;
                } else {
                    return false;
                }
            } else {
                if (str[s] == pat[p]) {
                    s++;
                    p++;
                } else {
                    return false;
                }
            }
        }
        return (s == str.length && p == pat.length);
    }

    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        PatternMatching solution = new PatternMatching();
        boolean result = solution.matchPattern("string", "s5");
        System.out.println(result);
    }
}
