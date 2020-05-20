package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringDistinctCharacter {
    int longestSubstring(String input) {
        int s = 0;
        int longest = 0;
        Set<Character> distinct = new HashSet<>();
        for (int f = 0; f < input.length(); f++) {
            if (!distinct.contains(input.charAt(f))) {
                distinct.add(input.charAt(f));
                longest = Math.max(f - s + 1, longest);
            } else {
                distinct.remove(input.charAt(s++));
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringDistinctCharacter solution = new LongestSubstringDistinctCharacter();
        System.out.println(solution.longestSubstring("abcdefgahij"));
    }
}
