package Array;
import java.util.Arrays;

public class RainbowSort {
	
	public static void main(String[] args) {
		int[] array = new int[] { 1, 1, 0, -1, 0, 1, -1};
		rainbowSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static int[] rainbowSort(int[] array) {
	    if (array == null || array.length <= 1) {
	      return array;
	    }
	    // [0, neg) : -1
	    // [neg, zero) : 0
	    // [zero, one] : unknown
	    // (one, n] : 1
	    int neg = 0;
	    int zero = 0;
	    int one = array.length - 1;
	    while (zero <= one) {
	      if (array[zero] == 0) {
	        zero++;
	      } else if (array[zero] == 1) {
	        swap(array, zero, one--);
	      } else {
	        swap(array, zero++, neg++);
	      }
	    }
	    return array;
	  }

	  private static void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }
}
