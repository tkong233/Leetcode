package Array;

public class SortNColors {
    /*
        Given a color array consists of k kinds of colors, index from 1 to k.
        Sort them in increasing order.
        e.g. k = 4, [1, 3, 2, 4, 2, 1] => [1, 1, 2, 2, 3, 4]
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length <= 1) {
            return;
        }

        int[] pointers = new int[k + 1];
        while (pointers[k] <= colors.length - 1) {
            int curValue = colors[pointers[k]];
            for (int otherPointer = k; otherPointer >= curValue + 1; otherPointer--) {
                swap(colors, pointers[otherPointer], pointers[otherPointer - 1]);
            }
            for (int pointer = curValue; pointer <= k; pointer++) {
                pointers[pointer] = pointers[pointer] + 1;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
