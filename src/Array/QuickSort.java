package Array;

import java.util.Arrays;

//Input: new int[]{4,2,1,6,3,5}
//expected [1,2,3,4,5,6] but was: [3,1,2,5,4,6]

public class QuickSort {
	
	public static void main(String args[]) {
		int[] array = {1, 3, 4, 2, 5};
		QuickSort solution = new QuickSort();
		solution.solve(array);
		System.out.println(Arrays.toString(array));
	}

	public int[] solve(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		selectionSort(array, 0, array.length - 1);
		return array;
	}

	private void selectionSort(int[] array, int leftBound, int rightBound) {
		if (leftBound >= rightBound) {
			return;
		}
		int pivotPos = partition(array, leftBound, rightBound);
		selectionSort(array, leftBound, pivotPos - 1);
		selectionSort(array, pivotPos + 1, rightBound);
	}

	// pick a pivot p randomly
	// partition the array into two parts so that elements on the left < p, elements on the right > p
	// return position of p
	private int partition(int[] array, int leftBound, int rightBound) {
		int pivotPos = getPivotPos(leftBound, rightBound);
		int pivot = array[pivotPos];
		swap(array, pivotPos, rightBound);
		int left = leftBound;
		int right = rightBound - 1;
		while (left <= right) {
			if (array[left] < pivot) {
				left++;
			} else if (array[right] > pivot) {
				right--;
			} else {
				swap(array, left++, right--);
			}
		}
		swap(array, left, rightBound);
		return left;
	}

	private int getPivotPos(int left, int right) {
		return left + (int) (Math.random() * (right - left + 1));
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
