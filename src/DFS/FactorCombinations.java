package DFS;
import java.util.*;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationsHelper(result, new ArrayList<>(), target, 2);
        return result;
    }

    private void combinationsHelper(List<List<Integer>> result, List<Integer> cur, int target, int index) {
        if (index >= target) {
            if (target == 1) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }

        int factor = index;
        for (int i = 1; factor <= target; i++) {
            if (target % factor != 0) {
                factor *= index;
                continue;
            }
            for (int j = 0; j < i; j++) {
                cur.add(index);
            }
            combinationsHelper(result, cur, target / factor, index + 1);
            for (int j = 0; j < i; j++) {
                cur.remove(cur.size() - 1);
            }
            factor *= index;
        }
        combinationsHelper(result, cur, target, index + 1);
    }

    public static void main(String[] args) {
        FactorCombinations solution = new FactorCombinations();
        List<List<Integer>> result = solution.combinations(12);
        for (List<Integer> s : result) {
            System.out.println(s.toString());
        }
    }
}
