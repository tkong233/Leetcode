package Array;
import java.util.*;

public class MergeIntervals {
    class Pair implements Comparable<Pair> {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Pair other) {
            if (this.start == other.start && this.end == other.end) {
                return 0;
            }
            if (this.start < other.start) {
                return -1;
            }
            if (this.start == other.start) {
                return this.end <= other.end ? -1 : 1;
            }
            return 1;
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length < 2) {
            return new int[0][0];
        }
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        // (1, 1) (1, 3) (2, 4) (5, 8)
        // prevStart = 1
        // prevEnd = 1
        // case 1: curStart == prevStart => prevEnd = max(prevEnd, curEnd)
        // case 2: curStart > prevStart && curStart < prevEnd => prevEnd = max(prevEnd, curEnd)
        // case 3: curStart > prevEnd => new interval. update prevStart and prevEnd
        Collections.sort(list);
        List<Pair> result = new ArrayList<>();
        result.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Pair cur = list.get(i);
            Pair prev = list.get(i - 1);
            if (cur.start >= prev.start && cur.start <= prev.end) {
                prev.end = Math.max(cur.end, prev.end);
            } else {
                result.add(cur);
            }
        }
        int[][] array = new int[result.size()][2];
        for (int i = 0; i < array.length; i++) {
            Pair cur = result.get(i);
            array[i][0] = cur.start;
            array[i][1] = cur.end;
        }
        return array;
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] intervals = new int[3][2];
        intervals[0] = new int[] {1, 4};
        intervals[1] = new int[] {0, 2};
        intervals[2] = new int[] {3, 5};
        int[][] result = solution.merge(intervals);
        for (int[] a: result) {
            System.out.println(a[0] + " " +  a[1]);
        }
    }
}
