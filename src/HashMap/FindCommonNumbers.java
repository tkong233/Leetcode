package HashMap;

import DFS.FindCombination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCommonNumbers {
    List<Integer> findCommonNumbers(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int e : a) {
            set.add(e);
        }
        for (int e : b) {
            if (set.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] input2 = new int[] {3, 4, 5, 7, 9};

        FindCommonNumbers solution = new FindCommonNumbers();
        List<Integer>result = solution.findCommonNumbers(input1, input2);
        System.out.println(result.toString());
    }
}
