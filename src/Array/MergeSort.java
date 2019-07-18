package Array;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = new int[] {0, 2, 1, 4, 6, 2, 3};
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void mergeSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		mergeSortHelper(array, 0, array.length - 1);
	}
	
	private static void mergeSortHelper(int[] array, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSortHelper(array, left, mid);
			mergeSortHelper(array, mid + 1, right);
			combine(array, left, mid, right);
		}
	}
	
	private static void combine(int[] array, int l, int m, int r) {
		// 0 1 2 3 4
		// l   m   r
		int sizeL = m - l + 1;
		int sizeR = r - m;
		
		int[] L = new int[sizeL];
		int[] R = new int[sizeR];
		
		for(int i = 0; i < sizeL; i++) {
			L[i] = array[l + i];
		}
		
		for(int i = 0; i < sizeR; i++) {
			R[i] = array[m + i + 1];
		}
		
		int left = 0;
		int right = 0;
		int i = l;
		while (left < sizeL && right < sizeR) {
			array[i] = L[left] < R[right] ? L[left++] : R[right++];
			i++;
		}
		
		while (left < sizeL) {
			array[i++] = L[left++];
		}
		
		while (right < sizeR) {
			array[i++] = R[right++];
		}
		
	}
	
}