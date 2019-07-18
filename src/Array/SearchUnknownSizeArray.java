package Array;
import java.util.HashMap;
import java.util.Map;

public class SearchUnknownSizeArray {
	public static void main(String[] args) {
		Map dict = new HashMap<Integer, Integer>();
		dict.put(0, 1);
		dict.put(1, 3);
		dict.put(2, 4);
		dict.put(3, 4);
		dict.put(4, 6);
		dict.put(5, 10);
		dict.put(6, 11);
		dict.put(7, 12);
		dict.put(8, 15);
		dict.put(9, 15);
		
		System.out.println(search(dict, 15));
	}
	
	public static int search(Map<Integer, Integer> dict, int target) {
	    if (dict == null || dict.get(0) == null) {
	      return -1;
	    }
	    if (dict.get(0) == target) {
	      return 0;
	    }
	    int i  = 1;
	    int val = dict.get(0);
	    while (val < target) {
	      i *= 2;
	      if (dict.get(i) != null) {
	        val = dict.get(i);
	      } else {
	        break;
	      }
	    }
	    int left = i / 2;
	    int right = i;
	    while (left <= right) {
	      int mid = left + (right - left) / 2;
	      int midVal = dict.get(mid);
	      if (midVal == target) {
	        return mid;
	      } else if (midVal < target) {
	        left = mid + 1;
	      } else {
	        right = mid - 1;
	      }
	    }
	    return -1;
	  }
}
