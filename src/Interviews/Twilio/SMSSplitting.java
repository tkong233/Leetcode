package Interviews.Twilio;
import java.util.*;

public class SMSSplitting {
    private static String PUNCTUATIONS = ",.;:/?'!`~@#$%^&*()_+\"";

    public static List<String> segments(String message) {
        List<String> result = new ArrayList<>();
        if (message.length() <= 160) {
            result.add(message);
            return result;
        }

        List<StringBuilder> splitted = getSplittedSegments(message);
        int total = splitted.size();
        int cur = 1;
        while (cur <= total) {
            StringBuilder sb = splitted.get(cur - 1);
            sb.append("(" + cur + "/" + total + ")");
            result.add(sb.toString());
            cur++;
        }

        return result;

    }

    private static List<StringBuilder> getSplittedSegments(String message) {
        int suffixLength = 5;
        int curSegmentStart = 0;
        int curSegmentEnd = 160 - suffixLength - 1;

        StringBuilder sb = new StringBuilder();
        List<StringBuilder> result = new LinkedList<>();
        while (curSegmentStart < message.length()) {
            if (curSegmentEnd > message.length()) {
                curSegmentEnd = message.length() - 1;
            }

            if (isLetter(message.charAt(curSegmentEnd))) {
                curSegmentEnd = findNearstWordBreakBefore(message, curSegmentEnd);
            }

            sb.append(message.substring(curSegmentStart, curSegmentEnd + 1));
            StringBuilder sbClone = new StringBuilder(sb.toString());
            result.add(sbClone);
            sb.setLength(0);
            curSegmentStart = curSegmentEnd + 1;
            curSegmentEnd = curSegmentStart + 160 - suffixLength - 1;
        }

        return result;
    }

    private static int findNearstWordBreakBefore(String message, int i) {
        while (isLetter(message.charAt(i))) {
            i--;
        }
        return i;
    }

    private static boolean isPunctuation(char c) {
        return PUNCTUATIONS.contains("" + c);
    }

    private static boolean isSpace(char c) {
        return c == ' ';
    }

    private static boolean isLetter(char c) {
        return Character.isAlphabetic(c);
    }

    public static void main(String[] args) {
        SMSSplitting solution = new SMSSplitting();
        List<String> result = solution.segments("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
