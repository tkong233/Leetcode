package Array;

public class BinarySearch {
	
	
	
	int binarySearch(int[] a, int target) {
		int left = 0;
		int right = a.length - 1;
	//	int mid = a.length / 2;		合并到while loop内，令 mid = left + (right - left) / 2
		
		while(left <= right) {			// why has to be <= ?	--> when a.length = 1, left = right
			int mid = left + (right - left) / 2;
			if(a[mid] == target) {
				return mid;
			}
			else if(target > a[left]) {
				left = mid + 1;		// why can't be left = mid ? --> division rounds down, 
			}
			else {
				right = mid - 1;	// right = mid is correct
			}
		}
		
		if(target == a[left]) {
			return left;
		}
		else {
			return -1;
		}
	}

}
