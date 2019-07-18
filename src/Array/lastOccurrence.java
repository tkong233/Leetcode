package Array;

import java.util.Arrays;

public class lastOccurrence {
	public static int lastOccur(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] <= target) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		
		if(array[left] == target) {
			return left;
		}
		
		if(array[right] == target) {
			return right;
		}
		
		return -1;
	
	}
	
	public static void main(String args[]) {
		int[] array = {1, 2, 3, 4, 4, 4, 6, 9};
		int result = lastOccur(array, 4);
		System.out.println(result);
	}
}
