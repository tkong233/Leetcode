package CodeSignal;
import java.util.*;

public class BrokenKeyboard {
    private static int brokenKeyboard(String text, char[] letters) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < letters.length; i++) {
            char l = letters[i];
            set.add(l);
            set.add(Character.toUpperCase(l));
        }
        String[] words = text.split("\\s+");
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (canType(words[i], set)) {
                result++;
            }
        }
        return result;
    }

    private static boolean canType(String word, Set<Character> set) {
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (!Character.isAlphabetic(cur)) {
                continue;
            }
            if (!set.contains(cur)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        brokenKeyboard("3 + 2 = 5", new char[] {});
    }
}
