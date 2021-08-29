package CodeSignal;

import java.util.ArrayList;
import java.util.List;

public class ConcatSwaps {
    String concatSwaps(String s, int[] sizes) {
        List<String> substrings = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < sizes.length; i++) {
            int end = start + sizes[i];
            substrings.add(s.substring(start, end));
            start = end;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substrings.size(); i += 2) {
            if (i + 1 < substrings.size()) {
                sb.append(substrings.get(i + 1));
                sb.append(substrings.get(i));
            }
        }
        if (substrings.size() % 2 != 0) {
            sb.append(substrings.get(substrings.size() - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConcatSwaps solution = new ConcatSwaps();
        String result = solution.concatSwaps("descognail", new int[] {3, 2, 3, 1, 1});
        System.out.println(result);
    }
}
