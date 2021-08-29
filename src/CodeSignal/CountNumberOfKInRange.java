package CodeSignal;

public class CountNumberOfKInRange {
//    int countNumberOf024(int num) {
//
//    }
    // assumes 0 <= number <= 1000
    static int numberOf0InRange(int number) {
        int count = 1; // at least one zero for 0
        int power = 1;
        int powerOfTen = (int) Math.pow(10, power);
        while (powerOfTen <= number) { // cases where number ends with 0
            count += number / powerOfTen;
            power++;
            powerOfTen = (int) Math.pow(10, power);
        }
        // cases of x0x
//        int hundred = 109;
//        while (hundred <= number) {
//            count += 9;
//            hundred += 100;
//        }
//        int lastHundred = hundred - 9;

        return count;
    }

    static int countKsInRangeAtDigit(int number, int d, int k) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowerOf10;
        int roundup = roundDown + nextPowerOf10;

        int digit = (number / powerOf10) % 10;

        // if the digit in spot digit is
        if (digit < k) {
            return roundDown / 10;
        }

        if (digit == k)
        {
            return roundDown / 10 + right + 1;
        }
        return roundup / 10;
    }

    // Counts the number of '2' digits between 0 and n
    static int numberOf24sinRange(int number)
    {
        int length = String.valueOf(number).length();
        int count = 0;
        for (int digit = 0; digit < length; digit++)
        {
            count += countKsInRangeAtDigit(number, digit, 2);
            count += countKsInRangeAtDigit(number, digit, 4);
            count += countKsInRangeAtDigit(number, digit + 1, 0);
        }

        return count + 1;
    }

    static int numberOf024sInRange(int number) {
        int count24 = numberOf24sinRange(number);
        int count0 = numberOf0InRange(number);
        return count24 + count0;
    }

    static int bruteForce0(int number) {
        int cur = 0;
        int count = 0;
        while (cur <= number) {
            String s = String.valueOf(cur);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    count++;
                }
            }
            cur++;
        }
        return count;
    }

    static int bruteForce24(int number) {
        int cur = 0;
        int count = 0;
        while (cur <= number) {
            String s = String.valueOf(cur);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '2' || c == '4') {
                    count++;
                }
            }
            cur++;
        }
        return count;
    }


    static int bruteForce024(int number) {
        int cur = 0;
        int count = 0;
        while (cur <= number) {
            String s = String.valueOf(cur);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0' || c == '2' || c == '4') {
                    count++;
                }
            }
            cur++;
        }
        return count;
    }

    // Driver Code
    public static void main(String[] args)
    {
//        System.out.println(numberOf024sInRange(8));
//        System.out.println(bruteForce(8));
//        System.out.println(numberOf024sInRange(23));
//        System.out.println(bruteForce(23));
//        System.out.println(numberOf024sInRange(209));
//        System.out.println(bruteForce0(209));
//        System.out.println(numberOf0InRange(209));
//        System.out.println(bruteForce24(209));
//        System.out.println(numberOf24sinRange(209));
        System.out.println(bruteForce024(289));
//        System.out.println(numberOf024sInRange(209));
        System.out.println(numberOf24sinRange(289));
    }
}
