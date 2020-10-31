package Interviews.Bloomberg;
import java.util.*;

public class RemoveKAdjacentDuplicates {

    public String removeDuplicates1(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> counts = new ArrayDeque<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i ==  0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.offerFirst(1);
                continue;
            }
            int incrementedCount = counts.pollFirst() + 1;
            if (incrementedCount == k) {
                sb.delete(i - k + 1, i + 1);
                i = i - k;
                continue;
            }
            counts.offerFirst(incrementedCount);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        RemoveKAdjacentDuplicates solution =new RemoveKAdjacentDuplicates();
        String result = solution.removeDuplicates("deeedbbcccbdaa", 3);
        System.out.println(result);
    }
}
