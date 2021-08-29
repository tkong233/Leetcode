package CodeSignal;

import java.util.*;

public class CyclicArrays {
    int numberOfCyclicArrays(List<List<Integer>> list) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (visited.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < list.size(); j++) {
                if (isCyclic(list.get(i), list.get(j))) {
                    visited.add(i);
                    visited.add(j);
                }
            }
        }
        return visited.size();
    }

    boolean isCyclic(List<Integer> one, List<Integer> two) {
        // 1 2 3 4
        // 3 4 1 2
        int start1Num = one.get(0);
        int start2 = 0;
        while (start2 < two.size() && two.get(start2) != start1Num) {
            start2++;
        }
        for (int start1 = 0; start1 < one.size(); start1++) {
            if (one.get(start1) != two.get(start2)) {
                return false;
            }
            start2 = (start2 == two.size() - 1) ? 0 : start2 + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        CyclicArrays solution = new CyclicArrays();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 3, 4, 5));
        input.add(Arrays.asList(2, 3, 4, 5, 1));
        input.add(Arrays.asList(3, 4, 5, 1, 1));
        input.add(Arrays.asList(5, 1, 2, 3, 4));
        input.add(Arrays.asList(1, 2, 3));
        input.add(Arrays.asList(2, 3, 1));

        int result = solution.numberOfCyclicArrays(input);
        System.out.println(result);
    }

}
