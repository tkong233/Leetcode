package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class maxTickets {
    static int maxTickets(List<Integer> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return 0;
        }
        if (tickets.size() == 1) {
            return 1;
        }
        Collections.sort(tickets);
        int max = 1;
        int prev = tickets.get(0);
        int curMax = 1;
        for (int i = 1; i < tickets.size(); i++) {
            int cur = tickets.get(i);
            int diff = cur - prev;
            if (diff <= 1) {
                curMax++;
                max = Math.max(max, curMax);
            } else {
                curMax = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maxTickets(Arrays.asList(4, 13, 2, 3));
    }
}
