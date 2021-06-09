package Array;

public class ClosestKElements {
    public static void main(String[] args) {
        ClosestKElements solution = new ClosestKElements();
        solution.kClosest(new int[] {1, 5}, 2, 1);
    }
    public int[] kClosest(int[] array, int target, int k) {
        int result[] = new int[k];
        // find closest element
        int closest = findClosestElement(array, target);
        int left = closest;
        int right = closest + 1;
        int i = 0;
        for (; i < k; i++) {
            if (left < 0 || right > k - 1) {
                break;
            }
            if (array[left] <= array[right]) {
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }

        if (i < k) {
            while (left >= 0) {
                result[i++] = array[left--];
            }
            while (right <= array.length - 1) {
                result[i++] = array[right++];
            }
        }
        return result;
    }

    private int findClosestElement(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(array[left] - target) < Math.abs(array[right] - target) ? left : right;
    }
}
