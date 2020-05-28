package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWord {
    boolean dictionaryWord(String input, Set<String> words) {
        if (input == null || words == null) {
            return false;
        }

        boolean[] canBreak = new boolean[input.length()];
        canBreak[0] = words.contains(input.substring(0, 1));
        for (int i = 1; i < input.length(); i++) {
            canBreak[i] = words.contains(input.substring(0, i + 1));

            for (int j = 1; j < i; j++) {
                if (canBreak[i] == true) {
                    break;
                }
                canBreak[i] = canBreak[j - 1] && words.contains(input.substring(j, i + 1));
            }
        }

        return canBreak[input.length() - 1];
    }

    public static void main(String[] args) {
        DictionaryWord solution = new DictionaryWord();
        Set<String> words = new HashSet<>();
        words.add("cat");
        words.add("dog");
        boolean result = solution.dictionaryWord("catadog", words);
        System.out.println(result);
    }
}
