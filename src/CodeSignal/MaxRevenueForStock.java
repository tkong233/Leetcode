package CodeSignal;

public class MaxRevenueForStock {
    private static int maxRevenue(int[] prices, int[] algo, int k) {
        int revenue = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (algo[i] == 0) {
                revenue -= prices[i];
            } else {
                revenue += prices[i];
            }
        }
        result = Math.max(revenue, result);

        for (int i = 0; i < k; i++) {
            if (algo[i] == 0) {
                revenue += prices[i] * 2;
            }
        }
        result = Math.max(revenue, result);

        int left = 1;
        int right = k;
        while (right < prices.length) {
            if (algo[left - 1] == 0) {
                revenue -= prices[left - 1] * 2;
            } else {
                revenue -= prices[left - 1];
            }
            revenue += prices[right] * 2;
            result = Math.max(revenue, result);
            left++;
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        maxRevenue(new int[] {2, 4, 1, 5, 2, 6, 7}, new int[] {0, 1, 0, 0, 1, 0, 0}, 4);
    }
}
