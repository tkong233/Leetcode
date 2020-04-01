package Sort;

import java.util.Arrays;

public class QuickSort {
    void quickSort(int[] input) {
        if (input.length <= 1) {
            return;
        }
        quickSortHelper(input, 0, input.length - 1);
    }
    // sub-problem: [leftBound, rightBound)
    // [0, 1, 2, 3]
     // l     r
    void quickSortHelper(int[] input, int leftBound, int rightBound) {
        // 过去错误：把base case条件写成 input.length - 1
        if (rightBound <= leftBound - 1) {
            return;
        }
        int pivotIndex = leftBound + (int) (Math.random() * (rightBound - leftBound + 1));
        int pivot = input[pivotIndex];
        swap(input, pivotIndex, rightBound);
        int i = leftBound;
        int j = rightBound - 1;
        // 过去错误：terminate condition：i和j应该错开后才停止。
        while(i <= j) {
            // 这里三个条件为互斥关系，保证每次循环只走一步
            // 否则可能前两个if中已经把i和j改变了，而在最后一个if中没有判断新的input[i]和input[j]的值就swap，导致错误
            if (input[i] < pivot) {
                i++;
            }
            else if (input[j] >= pivot) {
                j--;
            }
            else {
                swap(input, i, j);
                i++;
                j--;
            }
        }
        swap(input, i, rightBound);
        // 过去错误：这里i才是pivot最终的位置
        quickSortHelper(input, leftBound, i - 1);
        quickSortHelper(input, i + 1, input.length - 1);
    }

    void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] input = new int[]{1, 4, 5, 2, 6, 6, 3, 9, 4};
        solution.quickSort(input);
        System.out.println(Arrays.toString(input));
    }
}
