package Interviews.Google;

public class ValidTimePossibilities {
    public static int solution(String T) {
        int first = getFirstDigitPossibilities(T);
        int second = getSecondDigitPossibilities(T);
        int third = getThirdDigitPossibilities(T);
        int fourth = getFourthDigitPossibilities(T);

        return firstTwoDigitBothUnknown(T) ? (24 * third * fourth) : (first * second * third * fourth);
    }

    private static boolean firstTwoDigitBothUnknown(String s) {
        return s.charAt(0) == '?' && s.charAt(1) == '?';
    }

    // assumes second digit != '?'
    private static int getFirstDigitPossibilities(String s) {
        if (s.charAt(0) != '?') {
            return 1;
        }
        if (s.charAt(1) != '?' && s.charAt(1) > '3') {
            return 2;
        }
        return 3;
    }


    // assumes first digit != '?'
    private static int getSecondDigitPossibilities(String s) {
        if (s.charAt(1) != '?') {
            return 1;
        }
        if (s.charAt(0) == '2') {
            return 4;
        }
        return 10;
    }

    private static int getThirdDigitPossibilities(String s) {
        if (s.charAt(3) != '?') {
            return 1;
        }

        return 6;
    }

    private static int getFourthDigitPossibilities(String s) {
        if (s.charAt(4) != '?') {
            return 1;
        }

        return 10;
    }

    public static void main(String[] args) {

    }
}
