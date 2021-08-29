package CodeSignal;

public class MaxKOccurrences {
    static int[] maxKOccurrences(String sequence, String[] words) {
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = findOccurrences(sequence, words[i]);
        }
        return result;
    }

    static int findOccurrences(String s, String word) {
        int occur = 0;
        int i = 0;
        while (i < s.length()) {
            int curOccur = 0;
            while (i < s.length() && s.charAt(i) == word.charAt(0) && match(s, i, word)) {
                curOccur++;
                i += word.length();
            }
            occur = Math.max(occur, curOccur);
            i++;
        }
        return occur;
    }

    static boolean match(String s, int start, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (start + i >= s.length()) {
                return false;
            }
            if (s.charAt(start + i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] result = maxKOccurrences("ababcbabc", new String[] {"ab", "babc", "bca"});
        for (int s : result) {
            System.out.println(s);
        }
    }
}
