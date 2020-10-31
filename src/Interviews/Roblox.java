package Interviews;
import java.util.*;

public class Roblox {
    public static long prison(int horizontal,
                              int vertical,
                              List<Integer> removeH,
                              List<Integer> removeV) {
        int maxHorizontalLength = 1;
        int maxVerticalLength = 1;
        List<List<Integer>> horizontalHoleIntervals = new ArrayList<>();
        List<List<Integer>> verticalHoleIntegervals = new ArrayList<>();
        Collections.sort(removeH);
        Collections.sort(removeV);

        for (int h : removeH) {
            if (h < 1 || h > horizontal) {
                continue;
            }
            List<Integer> curInterval = Arrays.asList(h - 1, h + 1);
            horizontalHoleIntervals.add(curInterval);
        }

        for (int v : removeV) {
            if (v < 1 || v > vertical) {
                continue;
            }
            List<Integer> curInteval = Arrays.asList(v - 1, v + 1);
            verticalHoleIntegervals.add(curInteval);
        }

        mergeInterval(horizontalHoleIntervals);
        mergeInterval(verticalHoleIntegervals);

        for (List<Integer> interval : horizontalHoleIntervals) {
            if (interval.get(1) - interval.get(0) > maxHorizontalLength) {
                maxHorizontalLength = interval.get(1) - interval.get(0);
            }
        }

        for (List<Integer> interval : verticalHoleIntegervals) {
            if (interval.get(1) - interval.get(0) > maxVerticalLength) {
                maxVerticalLength = interval.get(1) - interval.get(0);
            }
        }

        long result = maxVerticalLength * maxHorizontalLength;

        return result;

    }

    private static void mergeInterval(List<List<Integer>> intervals) {
        if (intervals.size() <= 1) {
            return;
        }

        ListIterator<List<Integer>> iterator = intervals.listIterator();
        int id = 0;
        while (iterator.hasNext()) {
            List<Integer> cur = iterator.next();
            List<Integer> prev = iterator.previous();
            if (id == 0) {
                id++;
                continue;
            }

            if (cur.get(0) <= prev.get(1)) {
                prev.set(1, cur.get(1));
            }
            iterator.remove();
            id++;
        }
    }

    public static void main(String[] args) {
        Roblox solution = new Roblox();
        long result = solution.prison(3, 2, Arrays.asList(1, 2, 3), Arrays.asList(1, 2));
        System.out.println(result);
    }
}
