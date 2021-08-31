package CodeSignal;

import java.util.*;

public class TargetOccurrencesInRange {
    private static int targetOccurrencesInRange(int[] array, int[][] queries) {
        Map<Integer, List<Integer>> numToOcc = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> occ = numToOcc.getOrDefault(array[i], new ArrayList<>());
            occ.add(i);
            numToOcc.put(array[i], occ);
        }
        int result = 0;
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int target = queries[i][2];
            List<Integer> occ = numToOcc.getOrDefault(target, new ArrayList<>());
            for (int o : occ) {
                if (o >= left && o <= right) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        targetOccurrencesInRange(new int[] {1, 1, 2, 3, 2}, new int[][] {
                {1, 2, 1},
                {2, 4, 2},
                {0, 3, 1}
        });
    }
}
