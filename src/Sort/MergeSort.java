package Sort;

import java.util.Arrays;

public class MergeSort {
    // method 1: basic way
//    int[] mergeSort(int[] array) {
//        if (array == null || array.length <= 1) {
//            return array;
//        }
//        return mergeSort(array, 0, array.length - 1);
//    }
//
//    int[] mergeSort(int[] array, int left, int right) {
//        if (left == right) {
//            return new int[]{array[left]};
//        }
//        // 注意这里如何求mid能避免integer overflow
//        int mid = left + (right - left) / 2;
//        int[] leftResult = mergeSort(array, left, mid);
//        int[] rightResult = mergeSort(array, mid + 1, right);
//        return merge(leftResult, rightResult);
//    }
//
//    int[] merge(int[] leftResult, int[] rightResult) {
//        // 这里result产生的extra space可以通过一个helper array来优化
//        int[] result = new int[leftResult.length + rightResult.length];
//        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
//        while (leftIndex < leftResult.length && rightIndex < rightResult.length) {
//            if (leftResult[leftIndex] < rightResult[rightIndex]) {
//                result[resultIndex] = leftResult[leftIndex];
//                leftIndex++;
//            } else {
//                result[resultIndex] = rightResult[rightIndex];
//                rightIndex++;
//            }
//            resultIndex++;
//        }
//        while (leftIndex < leftResult.length) {
//            result[resultIndex] = leftResult[leftIndex];
//            leftIndex++;
//            resultIndex++;
//        }
//        while (rightIndex < rightResult.length) {
//            result[resultIndex] = rightResult[rightIndex];
//            rightIndex++;
//            resultIndex++;
//        }
//        return result;
//    }


    // method 2: Better. Using a helper array to guarantee no more than O(n) extra space
    public int[] mergeSort(int[] input) {
        int[] helper = new int[input.length];
        mergeSort(input, helper, 0, input.length - 1);
        return input;
    }

    void mergeSort(int[] input, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(input, helper, left, mid);
        mergeSort(input, helper, mid + 1, right);
        // 注意mid也要传
        merge(input, helper, left, mid, right);
    }

    // copy content of [left, right] into helper array
    // two sub-arrays to be merged: [left, mid] and [mid + 1, right]
    void merge(int[] input, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = input[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] < helper[rightIndex]) {
                input[left++] = helper[leftIndex++];
            } else {
                input[left++] = helper[rightIndex++];
            }
        }
        // if there are elements left on the left side, copy them into result
        while (leftIndex <= mid) {
            input[left++] = helper[leftIndex++];
        }
        // if there are elements left on the right side, no need to copy
        // as they are already in the correct position.
        return;
    }


    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[] input = new int[]{5, 2, 7, 4, 3, 5, 8, 6};
        int[] result = solution.mergeSort(input);
        System.out.println(Arrays.toString(result));
    }
}
