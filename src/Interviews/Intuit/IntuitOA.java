package Interviews.Intuit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntuitOA {
    static void reflowLines(int lineLength, List<String> lines) {
        if (lines == null || lines.size() == 0) {
            return;
        }

        List<String> rearrangedLines = rearrangeLines(lineLength, lines);

        for (String line : rearrangedLines) {
            int numSpaces = getNumSpace(line);
            if (numSpaces == 0) {
                System.out.println(line);
                continue;
            }

            int numDashToInsert = lineLength - line.length();
            int numDashForEachSpace = numDashToInsert / numSpaces;
            String newLine = insertDash(line, numDashForEachSpace);
            // 奇数dash会少一个
            System.out.println(newLine);
        }
        return;
    }
    public static List<String> rearrangeLines(int length, List<String> lines) {
        List<String> rearrangedLines = new LinkedList<>();

        StringBuilder nextLine = new StringBuilder();
        int curLineId = 0;

        while (curLineId < lines.size()) {
            String curLine = lines.get(curLineId);
            int nextWordStart = 0;

            while (nextWordStart < curLine.length()) {
                String nextWord = getNextWord(curLine, nextWordStart);
                nextWordStart += nextWord.length() + 1;
                if (nextLine.length() == 0 && nextWord.length() <= length) {
                    nextLine.append(nextWord);
                    continue;
                }

                if (nextLine.length() + nextWord.length() + 1 < length) {
                    nextLine.append(' ');
                    nextLine.append(nextWord);
                } else if (nextLine.length() + nextWord.length() + 1 == length) {
                    nextLine.append(' ');
                    nextLine.append(nextWord);
                    rearrangedLines.add(nextLine.toString());
                    nextLine.setLength(0);
                } else {
                    rearrangedLines.add(nextLine.toString());
                    nextLine.setLength(0);
                    nextLine.append(nextWord);
                }
            }

            if (curLineId == lines.size() - 1 && nextLine.length() != 0) {
                rearrangedLines.add(nextLine.toString());
            }

            curLineId++;
        }

        return rearrangedLines;
    }

    // start inclusive
    static String getNextWord(String line, int start) {
        if (start >= line.length()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (start < line.length()) {
            if (line.charAt(start) != ' ') {
                sb.append(line.charAt(start));
            } else {
                break;
            }
            start++;
        }

        return sb.toString();
    }

    public static int getNumSpace(String line) {
        if (line == null || line.length() == 0) {
            return 0;
        }

        int spaces = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                spaces += 1;
            }
        }

        return spaces;
    }

    public static String insertDash(String line, int numDashForEachSpace) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                for (int dash = 0; dash < numDashForEachSpace; dash++) {
                    sb.append('-');
                }
                continue;
            }

            sb.append(line.charAt(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("It was the best");
        lines.add("of times it was");
        lines.add("the worst of times");

        reflowLines(8, lines);
    }
}
