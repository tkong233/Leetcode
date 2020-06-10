package NineChapters.TwoPointers;

import java.util.Arrays;

public class RainbowSort {
    /*

     */

    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length <= 1) {
            return;
        }

        sortColorsHelper(colors, 0, colors.length - 1, 1, k);
    }

    void sortColorsHelper(int[] colors, int start, int end, int lowBound, int upBound) {
        if (lowBound == upBound) {
            return;
        }
        if (start >= end) {
            return;
        }

        int pivot = lowBound + (upBound - lowBound) / 2;
        int mid = partition(colors, start, end, pivot); // mid = first element >= pivot
        sortColorsHelper(colors, start, mid - 1, lowBound, pivot);
        sortColorsHelper(colors, mid, end, pivot + 1, upBound);
    }

    int partition(int[] colors, int start, int end, int pivot) {
        int left = start;
        int right = end;
        while (left <= right) {
            if (colors[left] < pivot) {
                left++;
            } else if (colors[right] >= pivot) {
                right--;
            } else {
                swap(colors, left++, right--);
            }
        }

        return left;
    }

    void swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    public static void main(String[] args) {
        RainbowSort solution = new RainbowSort();
        int[] array = new int[] {2, 1, 1, 2, 2};
        solution.sortColors2(array, 2);
        System.out.println(Arrays.toString(array));
    }
}
