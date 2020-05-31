package Array;

import java.util.Arrays;

public class RemoveDuplicateII {
    /*
        Given a sorted array, remove duplicate elements.
        If there an element occur multiple times, leave at most two copies.
     */

    int[] removeDup(int[] array) {
        if (array == null || array.length <= 2) {
            return array;
        }

        int slow = 2;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] == array[slow - 2]) {
                continue;
            }
            array[slow++] = array[fast];
        }

        return Arrays.copyOf(array, slow);
    }

    public static void main(String[] args) {
        RemoveDuplicateII solution = new RemoveDuplicateII();
        int[] result = solution.removeDup(new int[] {1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7});
        System.out.println(Arrays.toString(result));
    }
}
