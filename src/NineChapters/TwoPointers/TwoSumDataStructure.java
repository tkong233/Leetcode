package NineChapters.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDataStructure {
    /*
        Design and implement a TwoSum class. It should support the following operations: add and find.

        add - Add the number to an internal data structure.
        find - Find if there exists any pair of numbers which sum is equal to the value.
     */

    Map<Integer, Integer> numCount;

    public void add(int number) {
        if (numCount == null) {
            numCount = new HashMap<>();
        }

        int count = numCount.getOrDefault(number, 0);
        numCount.put(number, count + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        if (numCount == null) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            int complement = value - num;
            if (complement == num) {
                return count >= 2;
            }
            if (numCount.getOrDefault(complement, 0) > 0) {
                return true;
            }
        }

        return false;
    }
}
