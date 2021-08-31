package CodeSignal;
import java.util.*;

public class CloseEnoughStrings {
    private static boolean closeEnough(String s1, String s2) {
        Map<Character, Integer> charToFreq1 = getFreqMap(s1);
        Map<Character, Integer> charToFreq2 = getFreqMap(s2);
        List<Integer> l1 = new ArrayList<>(charToFreq1.values());
        List<Integer> l2 = new ArrayList<>(charToFreq2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }

    private static Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freq = map.getOrDefault(c, 0);
            map.put(c, freq + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        boolean result = closeEnough("bazccm", "bazccb");
        System.out.println(result);
    }
}
