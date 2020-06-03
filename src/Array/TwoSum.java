package Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return new int[] {-1, -1};
        }

        // key = value, value = index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            Integer complement = map.get(target - cur);
            if (complement != null) {
                return new int[] {complement, i};
            }
            map.put(cur, i);
        }

        return new int[] {-1, -1};
    }
}
