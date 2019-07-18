package Array;

import java.util.Arrays;

public class Array2D {

	public static int[] search(int[][] matrix, int target) {
		int[] result = new int[] { -1, -1 };
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int left = 0;
		int length = matrix.length * matrix[1].length;
		int right = length - 1;
		while (left <= right && left < length && right < length) {
			int mid = left + (right - left) / 2;
			int row = mid / matrix[0].length;
			int col = mid % matrix[0].length;
			if (matrix[col][row] == target) {
				result[0] = col;
				result[1] = row;
				return result;
			} else if (matrix[col][row] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		int[][] array =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		System.out.println(Arrays.toString(search(array, 6)));
	}
}
