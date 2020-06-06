import java.util.Arrays;

public class Test {

    public void sortIntegers2(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }

        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    void mergeSort(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid, temp);
        mergeSort(array, mid + 1, end, temp);
        merge(array, start, mid, end, temp);
    }

    void merge(int[] array, int start, int mid, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }

        int leftIndex = start;
        int rightIndex = mid + 1;
        int cur = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (temp[leftIndex] < temp[rightIndex]) {
                array[cur++] = temp[leftIndex++];
            } else {
                array[cur++] = temp[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            array[cur++] = temp[leftIndex++];
        }
    }

    public static void main(String[] args) {
        Test solution = new Test();
        int[] a = new int[] {3, 2, 1, 4, 5};
        solution.sortIntegers2(a);
        System.out.println(Arrays.toString(a));

    }
}
