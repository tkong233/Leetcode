package Sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }

    void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = a[start + (end - start) / 2];
        while (left <= right) {
            if (a[left] < pivot) {
                left++;
            } else if (a[right] > pivot) {
                right--;
            } else {
                swap(a, left++, right--);
            }
        }

        quickSort(a, start, right);
        quickSort(a, left, end);
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] input = new int[]{3, 1, 2, 4, 5};
        solution.quickSort(input);
        System.out.println(Arrays.toString(input));
    }
}
