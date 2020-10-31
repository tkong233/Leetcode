package Interviews.Google;

public class MaximumTime {
    /*
        You are given a string that represents time in the format hh:mm.
        Some of the digits are blank (represented by ?).
        Fill in ? such that the time represented by this string is the maximum possible.
        Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.
     */

    String maximumTime(String input) {
        if (input == null || input.length() != 5) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        fillFirst(sb, input.charAt(0), input.charAt(1));
        fillSecond(sb, sb.charAt(0), input.charAt(1));
        sb.append(':');
        fillThird(sb, input.charAt(3));
        fillFourth(sb, input.charAt(4));

        return sb.toString();
    }

    void fillFirst(StringBuilder sb, char first, char second) {
        if (first != '?') {
            sb.append(first);
            return;
        }
        if (second != '?' && second > '3') {
            sb.append('1');
            return;
        }
        sb.append('2');
    }

    void fillSecond(StringBuilder sb, char first, char second) {
        if (second != '?') {
            sb.append(second);
            return;
        }
        if (first == '2') {
            sb.append('3');
            return;
        }
        sb.append('9');
    }

    void fillThird(StringBuilder sb, char third) {
        sb.append(third == '?' ? '5' : third);
    }

    void fillFourth(StringBuilder sb, char fourth) {
        sb.append(fourth == '?' ? '9' : fourth);
    }



    public static void main(String[] args) {
        MaximumTime solution = new MaximumTime();
        String result = solution.maximumTime("?4:5?");
        System.out.println(result);
    }
}
