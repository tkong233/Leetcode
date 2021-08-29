package CodeSignal;

public class ZigZag {
    static int[] zigzag(int[] numbers) {
        int[] result = new int[numbers.length - 2];
        for (int i = 0; i < result.length; i++) {
            int a = numbers[i];
            int b = numbers[i + 1];
            int c = numbers[i + 2];
            if ((a < b && b > c) || (a > b && b < c)) {
                result[i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        zigzag(new int[] {1, 2, 1, 3, 4});
    }
}
