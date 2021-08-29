package CodeSignal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinaryPatternMatching {
    /*
    You are given two strings pattern and s.
    The first string pattern contains only the symbols 0 and 1, and the second string s contains only lowercase English letters.

    Let's say that pattern matches a substring s[1...r] of s if the following 3 conditions are met:
    1. they have equal length;
    2. for each 0 in pattern, the corresponding letter in the substring is a vowel;
    3. for each 1 in patter, the corresponding letter is a consonant

    Your task is to calculate the number of substrings of s that match patter.

    Note: vowels = {a, e, i, o, u, y}. All other letters are consonants.

     */

    static int binaryPatternMatching(String pattern, String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
        int result = 0;
        for (int start = 0; start < s.length() - pattern.length(); start++) {
            boolean isMatch = true;
            for (int i = 0; i < pattern.length(); i++) {
                char c = s.charAt(start + i);
                if (pattern.charAt(i) == '0' && vowels.contains(c)) {
                    continue;
                } else if (pattern.charAt(i) == '1' && !vowels.contains(c)) {
                    continue;
                } else {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        binaryPatternMatching("010", "amazing");
    }
}
