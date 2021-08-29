package CodeSignal;

public class NumberSigningSum {
    private static int sum(int num) {
        String s = String.valueOf(num);
        int sum = 0;
        boolean isMinus = false;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (isMinus) {
                sum -= digit;
            } else {
                sum += digit;
            }
            isMinus = !isMinus;
        }
        return sum;
    }

    public static void main(String[] args) {
        sum(12345);
    }
}
