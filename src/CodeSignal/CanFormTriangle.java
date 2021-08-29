package CodeSignal;

public class CanFormTriangle {
    int[] canFormTriangle(int[] arr) {
        int[] result = new int[arr.length - 2];
        for (int i = 0; i < result.length; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int c = arr[i + 2];
            if (a + b > c && a + c > b && b + c > a) {
                result[i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CanFormTriangle solution = new CanFormTriangle();
        int[] result = solution.canFormTriangle(new int[] {1, 2, 2, 4});
    }
}
