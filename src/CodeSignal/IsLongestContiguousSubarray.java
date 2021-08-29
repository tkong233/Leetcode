package CodeSignal;
import java.util.*;
public class IsLongestContiguousSubarray {
    static boolean isLongestContiguousSubarray(int[] a, int[] b, int[] c) {
        Set<Integer> set = new HashSet<>();
        for (int e : c) {
            set.add(e);
        }
        int longest = 0;
        int fast = 0;
        int slow = 0;
        Set<Integer> longestStart = new HashSet<>();
        while (fast <= a.length) {
            if (fast == a.length || !set.contains(a[fast])) {
                int cur = fast - slow;
                if (cur >= longest) {
                    longest = cur;
                    longestStart.add(slow);
                }
                slow = fast + 1;
            }
            fast++;
        }

        if (b.length != longest) {
            return false;
        }

        for (int start : longestStart) {
            boolean matched = true;
            for (int i = 0; i < b.length; i++) {
                if (a[start + i] != b[i]) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean result = isLongestContiguousSubarray(new int[] {1, 1, 5, 1, 2}, new int[] {1, 1, 5, 1, 2}, new int[] {1, 5});
        System.out.println(result);
    }
}
