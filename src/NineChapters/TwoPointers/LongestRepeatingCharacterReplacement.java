package NineChapters.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    /*
    Given a string that consists of only uppercase English letters,
    you can replace any letter in the string with another letter at most k times.
    Find the length of a longest substring containing all repeating letters you can get
    after performing the above operations.
     */

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charFreq = new HashMap<>();
        int fast = 0;
        int maxFreq = 0;
        int result = 0;
        for (int slow = 0; slow < s.length(); slow++) {
            while (fast < s.length() && fast - slow - maxFreq <= k) {
                int count = charFreq.getOrDefault(s.charAt(fast), 0) + 1;
                charFreq.put(s.charAt(fast), count);
                maxFreq = Math.max(maxFreq, count);
                fast++;
            }

            if (fast - slow - maxFreq <= k) { //不能是fast == s.length()
                result = Math.max(result, fast - slow);
                break;
            }
            result = Math.max(result, fast - slow - 1);
            int count = charFreq.getOrDefault(s.charAt(slow), 0);
            charFreq.put(s.charAt(slow), count - 1);
            maxFreq = getMaxFreq(charFreq);
        }

        return result;
    }

    int getMaxFreq(Map<Character, Integer> charFreq) {
        int maxFreq = 0;
        for (Character c : charFreq.keySet()) {
            int freq = charFreq.get(c);
            maxFreq = Math.max(freq, maxFreq);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        int result = solution.characterReplacement("AABACCAAAC", 3);
        System.out.println(result);  // 9
    }
}
