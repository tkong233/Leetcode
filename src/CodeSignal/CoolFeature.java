package CodeSignal;
import java.util.*;
public class CoolFeature {
    private static List<Integer> coolFeature(int[] a, int[] b, int[][] query) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            int[] q = query[i];
            if (q[0] == 0) {
                b[q[1]] = q[2];
                continue;
            }
            int count = twoSum(a, b, q[1]);
            result.add(count);
        }
        return result;
    }

    private static int twoSum(int[] a, int[] b, int target) {
        Map<Integer, Integer> bValToFreq = new HashMap();
        for (int i = 0; i < b.length; i++) {
            int freq = bValToFreq.getOrDefault(b[i], 0);
            bValToFreq.put(b[i], freq + 1);
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += bValToFreq.getOrDefault(target - a[i], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        coolFeature(new int[] {1, 2, 2}, new int[] {2, 3}, new int[][] {
                {1, 4}, {0, 0, 3}, {1, 5}
        });
    }
}
