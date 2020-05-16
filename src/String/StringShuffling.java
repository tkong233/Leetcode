package String;

import java.util.Arrays;

public class StringShuffling {
    /*
        Array reorder in place implementation

        Suppose I have an array of chars, the requirement is as follow:
        1) [C_1, C_2, ... C_2k] => [C_1, C_k+1, C2, C_k+2, ..., C_k, C_2k]
        2)[C_1, C_2, ... C_2k+1] => [C_1, C_k+1, C2, C_k+2, ..., C_k, C_2k, C_2k+1]
     */

    public int[] reorder(int[] array) {
        // assumption: array is not null
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            // if array has odd number of elements,
            // we ignore the last one when do the reordring
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;  // [left, right] both ends inclusive
        // base case: if the subarray has 2 or 0 elements, just return
        if (length <= 2) {
            return;
        }
        // calculate the mid points:
        // 0 1   2 3   4 5   6 7
        // lm : 2, m: 4, rm: 6
        // 0 1   2 3 4   5 6   7 8 9
        // lm: 2, m: 5, rm: 7
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        // switchPosition不行，因为中间两个chunk的长度可能不一样
        // switchPosition(array, lmid, mid, rmid - 1);
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        // half of the left partition's size = lmid - left.
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }

    private void switchPosition(int[] array, int left, int mid, int right) {
        for (int i = 0; i < (mid - left); i++) {
            int temp = array[left + i];
            array[left + i] = array[mid + i];
            array[mid + i] = temp;
        }
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        StringShuffling solution = new StringShuffling();
        int[] result = solution.reorder(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(Arrays.toString(result));
    }
}
