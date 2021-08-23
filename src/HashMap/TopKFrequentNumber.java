package HashMap;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentNumber {
    class Pair {
        int value;
        int frequency;
        public Pair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            int freq = numToFreq.getOrDefault(num, 0);
            numToFreq.put(num, freq + 1);
        }
        Pair[] pairs = new Pair[numToFreq.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            pairs[i] = new Pair(entry.getKey(), entry.getValue());
            i++;
        }
        quickSelect(pairs, k, 0, pairs.length - 1);
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = pairs[j].value;
        }
        return result;
    }

    private void quickSelect(Pair[] pairs, int k, int left, int right) {
        int pivotPos = partition(pairs, left, right);
        if (pivotPos == k - 1) {
            return;
        } else if (pivotPos > k - 1) {
            quickSelect(pairs, k, left, pivotPos - 1);
        } else {
            quickSelect(pairs, k, pivotPos + 1, right);
        }
    }

    private int partition(Pair[] pairs, int leftBound, int rightBound) {
        int pivotPos = getPivotPos(leftBound, rightBound);
        int pivot = pairs[pivotPos].frequency;
        swap(pairs, pivotPos, rightBound);
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            if (pairs[left].frequency >= pivot) {
                left++;
            } else if (pairs[right].frequency < pivot) {
                right--;
            } else {
                swap(pairs, left++, right--);
            }
        }
        swap(pairs, left, rightBound);
        return left;
    }

    private int getPivotPos(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(Pair[] pairs, int i, int j) {
        Pair temp = pairs[i];
        pairs[i] = pairs[j];
        pairs[j] = temp;
    }

    public static void main(String[] args) {
        TopKFrequentNumber solution = new TopKFrequentNumber();
        int[] result = solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
