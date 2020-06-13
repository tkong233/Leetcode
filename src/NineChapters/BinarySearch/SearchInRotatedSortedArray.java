package NineChapters.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int left = 0;
        int right = A.length - 1;
        int start = A[left];
        int end = A[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > end) {
                if (target >= start && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= end && target > A[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int result = solution.search(new int[] {4, 5, 6, 1, 2}, 2);
        System.out.println(result);
    }
}
