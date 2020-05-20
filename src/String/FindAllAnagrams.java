package String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    /*
        Find all anagrams of a shorter string s1 in a longer string s2,
        return a list of starting index
     */

    List<Integer> findAllAnagrams(String s1, String s2) {
        // record characters & frequencies of s1
        Map<Character, Integer> map = new HashMap<>();
        countMap(map, s1);

        List<Integer> result = new LinkedList<>();
        int matchCount = 0;
        // 过去错误：不需要先把前是s1.length()个元素放进hash map作为init，
        // 只需要在for loop中，handle leftmost element之前加个conditional check即可

        for (int i = 0; i < s2.length(); i++) {
            // heandle newly added element
            char c = s2.charAt(i);
            Integer freq = map.get(c);
            if (freq != null) {
                map.put(c, freq - 1);
                if (freq == 1) {
                    matchCount += 1;
                }
                if (freq == 0) {
                    matchCount -= 1;
                }
            }

            // handle leftmost element, remove from sliding window
            if (i >= s1.length()) {
                c = s2.charAt(i - s1.length());
                freq = map.get(c);
                if (freq != null) {
                    map.put(c, freq + 1);
                    if (freq == 0) {
                        matchCount -= 1;
                    }
                    if (freq == -1) {
                        matchCount += 1;
                    }
                }
            }
            if (matchCount == map.size()) {
                result.add(i - s1.length() + 1);
            }
        }

        return result;
    }

    void countMap(Map<Character, Integer> map, String s1) {
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int freq = map.get(c);
                map.put(c, freq + 1);
            }
        }
    }


    public static void main(String[] args) {
        FindAllAnagrams solution = new FindAllAnagrams();
        List<Integer> result = solution.findAllAnagrams("bca", "abcabcabc");
        for (int i : result) {
            System.out.println(i);
        }
    }
}
