package NineChapters.TwoPointers;

public class KthLargestElement {
    /*
        Find K-th largest element in an array.

        You can swap elements in the array
     */

    public int kthLargestElement(int n, int[] nums) {
        if (n == 0 || nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, n, 0, nums.length - 1);
    }

    int quickSelect(int[] nums, int n, int start, int end)  {
        int mid = partition(nums, start, end);
        if (mid == n - 1) {
            return nums[mid];
        } else if (mid > n - 1) {
            return quickSelect(nums, n, start, mid - 1);
        } else {
            return quickSelect(nums, n, mid + 1, end);
        }
    }

    int partition(int[] nums, int start, int end) {
        int pivotId = start + (end - start) / 2;
        int pivot = nums[pivotId];
        swap(nums, pivotId, end);
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] >= pivot) {
                left++;
            } else if (nums[right] < pivot) {
                right--;
            } else {
                swap(nums, left++, right--);
            }
        }
        swap(nums, left, end);
        return left;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
