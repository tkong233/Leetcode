package Array;

import java.util.Arrays;

public class RemoveDuplicateI {
    /*
        Given a sorted array, remove duplicated elements. For elements appear multiple times, one leave one copy.
     */

    // method 1:
    // [0, slow) = processed elements
    // [fast] = element currently being processed
    // (fast, end] = element to be processed

    int[] removeDupI(int[] array) {
        // slow initialize在1，因为第一个element无论怎样都会被留下，可以认为已经process过并决定留下。
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow - 1]) {
                continue;
            }
            array[slow++] = array[fast];
        }
        return Arrays.copyOf(array, slow);
    }

    // method 2:
    // [0, slow] = processed elements
    // [fast] = element currently being processed
    // (fast, end] = elements to be processed

    int[] removeDupII(int[] array) {
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow]) {
                continue;
            }
            array[++slow] = array[fast];
        }

        return Arrays.copyOf(array, slow + 1);
    }

    public static void main(String[] args) {
        RemoveDuplicateI solution = new RemoveDuplicateI();
        int[] result = solution.removeDupII(new int[] {1, 2, 2, 3, 4, 4, 5, 5, 6});
        System.out.println(Arrays.toString(result));
    }
}
