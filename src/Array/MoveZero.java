package Array;

import java.util.Arrays;

//Given an array of integers, move all the 0s to the right end of the array.
//
//The relative order of the elements in the original array does not need to be maintained.
//
//Assumptions:
//
//The given array is not null.
//Examples:
//
//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}

public class MoveZero {
	public static void main(String args[]) {
		int[] array = {0, 1, 2, 0, 4, 1, 0};
		moveZero(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void moveZero(int[] array) {
		if(array == null) {
			return;
		}
		else {
			int i = 0;
			int j = array.length - 1;
			while(i < j) {
				if(array[j] == 0) {
					j--;
				}
				if(array[i] == 0) {
					swap(array, i++, j--);
				}
				else {
					i++;
				}
			}	
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
