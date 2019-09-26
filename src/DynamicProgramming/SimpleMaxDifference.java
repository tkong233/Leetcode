package DynamicProgramming;

public class SimpleMaxDifference {
    public static void main(String args[]) {
        int[] a1 = new int[] {1, 3, 4, 2, 5, 6}; // 5
        int[] a2 = new int[] {5, 7, 2, 3, 6}; // 4
        int[] a3 = null;  //-1
        int[] a4 = new int[6];  // initialized to all zeros // 0
        int[] a5 = new int[] {1}; // -1
        System.out.println(maxDifference(a1));
        System.out.println(maxDifference(a2));
        System.out.println(maxDifference(a3));
        System.out.println(maxDifference(a4));
        System.out.println(maxDifference(a5));


    }
    public static int maxDifference(int[] array) {
        if (array == null || array.length <= 1) {
            return -1;
        }
        int min = array[0];
        int max_diff = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] - min > max_diff) {
                max_diff = array[i] - min;
            }
        }
        return max_diff;
    }
}
