package CodeSignal;

public class MaxSizeCuttingRibbon {
    private static int maxSize(int[] ribbons, int k) {
        int left = 1;
        int right = 1;
        for (int i = 0; i < ribbons.length; i++) {
            right = Math.max(ribbons[i], right);
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int parts = getParts(ribbons, mid);
            if (parts >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int rightParts = getParts(ribbons, right);
        int leftParts = getParts(ribbons, left);
        return rightParts == k ? right : (leftParts == k) ? left : -1;
    }

    private static int getParts(int[] ribbons, int size) {
        int result = 0;
        for (int i = 0; i < ribbons.length; i++) {
            result += ribbons[i] / size;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = maxSize(new int[]{1, 2, 3, 4, 9}, 5);
        System.out.println(result);
    }

}
