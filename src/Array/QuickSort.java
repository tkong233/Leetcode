package Array;

import java.util.Arrays;

//Input: new int[]{4,2,1,6,3,5}
//expected [1,2,3,4,5,6] but was: [3,1,2,5,4,6]

public class QuickSort {
	
	public static void main(String args[]) {
		int[] array = {1, 3, 4, 2, 5};
		QuickSort solution = new QuickSort();
		solution.quickSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	  public int[] quickSort(int[] array) {
	    if (array == null || array.length == 0) {
	      return array;
    }
	    quickSort(array, 0, array.length - 1);
	    return array;
	}

	  private void quickSort(int[] array, int left, int right) {
	    if (left >= right) {
	      return;   // has to be void
	    }
	    int pivotPos = partition(array, left, right);

	    quickSort(array, left, pivotPos - 1);
	    quickSort(array, pivotPos + 1, right);
	  }
	  
	  // randomly select a pivot in [left, right] and return the correct position of it
	  private int partition(int[] array, int left, int right) {
	    int pivotPos = selectPivot(left, right);
	    int leftBound = left;
	    int rightBound = right;
	    while (leftBound <= rightBound) {
	      if (array[leftBound] < array[pivotPos]) {
	        leftBound++;
	      } else if (array[rightBound] >= array[pivotPos]) {
	        rightBound--;
	      } else {
	        swap(array, leftBound, rightBound);
	        leftBound++;
	        rightBound--;
	      }
	    }
	    return pivotPos;
	  }

	  private int selectPivot(int left, int right) {
	    return (int) (Math.random() * (right - left) + left);
	  }

	  private void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }

}
