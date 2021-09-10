package Interviews.Robinhood;
import java.util.*;

public class BadgeAccess {
    // given <name, timestamp> pairs, find people appeared >= 3 times within an hour
    // output: <B, 850, 890, 950>

    /*
       1. sort based on timestamp
       2. maintain a sliding window over one hour time window
          maintain a hashmap: {name -> list of access times within an hour}
          init: left, right both start at 0
          at each step:
            if right time - left time <= 100, add right entry to hashmap
                if size(access times) == 3 => add to result
            else: while right time - left time > 100, remove left entry from hashmap, left++.
     */
    List<String> findFrequentAccess(List<String[]> input) {
        List<List<String>> result = new ArrayList<>();
        Collections.sort(input, new Comparator<String[]>() {
           @Override
           public int compare(String[] s1, String[] s2) {
                int t1 = Integer.valueOf(s1[1]);
                int t2 = Integer.valueOf(s2[2]);
                if (t1 == t2) {
                    return 0;
                }
                return t1 < t2 ? -1 : 1;
           }
        });
        System.out.println(input.toString());
        return null;
    }

    public static void main(String[] args) {
        BadgeAccess solution = new BadgeAccess();
        solution.findFrequentAccess(Arrays.asList(new String[] {"A", "1500"}, new String[] {}));
    }
}
