package Array;

import java.util.Arrays;

public class RemoveDuplicateIII {
    /*
        Given an unsorted array, only leave element that occurs exactly once.
     */

    // method 1: check if a[f] != a[f - 1] && a[f] != a[f + 1]
    int[] removeDup(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int slow = 0;
        for (int fast = 0; fast <= array.length - 2; fast++) {
            if (fast == 0) {
                if (array[fast] != array[fast + 1]) {
                    array[slow++] = array[fast];
                }
            } else {
                if (array[fast] != array[fast + 1] && array[fast] != array[fast - 1]) {
                    array[slow++] = array[fast];
                }
            }
        }

        // post processing: check if the last element should be kept
        if (array[array.length - 1] != array[array.length - 2]) {
            array[slow++] = array[array.length - 1];
        }

        return Arrays.copyOf(array, slow);
    }

    // method 2: use f_next to find next element different from f
    int[] removeDupII(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            int next = fast + 1;
            while (next < array.length && array[next] == array[fast]) {
                next++;
            }
            if (next - fast == 1) {
                array[slow++] = array[fast];
            }
            fast = next;
        }

        return Arrays.copyOf(array, slow);
    }

    public static void main(String[] args) {
        RemoveDuplicateIII solution = new RemoveDuplicateIII();
        int[] result = solution.removeDupII(new int[] {1, 1, 2, 3, 3, 4, 4, 5, 6, 7, 7, 7, 8, 9});
        System.out.println(Arrays.toString(result));
    }
}
