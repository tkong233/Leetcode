package NineChapters.DFS;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static String[] LETTER_MAP = new String[] {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        StringBuilder cur = new StringBuilder();

        if (digits == null || digits.length() == 0) {
            result.add(cur.toString());
            return result;
        }

        dfs(digits, 0, result, cur);
        return result;
    }

    void dfs(String digits, int digitIndex, List<String> result, StringBuilder cur) {

        if (digitIndex == digits.length()) {
            result.add(cur.toString());
            return;
        }
        int curDigit = digits.charAt(digitIndex) - '0';
        String letters = LETTER_MAP[curDigit];
        for (int i = 0; i < letters.length(); i++) {
            cur.append(letters.charAt(i));
            dfs(digits, digitIndex + 1, result, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        List<String> result = solution.letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
