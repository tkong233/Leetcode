package NineChapters.DFS;
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        if (candidates == null) {
            return result;
        }
        if (candidates.length == 0 || target <= 0) {
            result.add(cur);
            return result;
        }

        Arrays.sort(candidates);
        int[] distinctCandidates = removeDuplicates(candidates);
        dfs(distinctCandidates, target, 0, result, cur);
        return result;
    }

    void dfs(int[] candidates,
             int targetRemain,
             int index,
             List<List<Integer>> result,
             List<Integer> cur) {
        if (index == candidates.length || targetRemain < 0) {
            return;
        }
        if (targetRemain == 0) {
            result.add(new LinkedList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(candidates, targetRemain - candidates[i], i, result, cur);
            // 注意传给 dfs 的 index 是 i 而不是当前的 index
            cur.remove(cur.size() - 1);
        }
    }

    int[] removeDuplicates(int[] candidates) {
        int slow = 0;
        for (int fast = 1; fast < candidates.length; fast++) {
            if (candidates[fast] == candidates[slow]) {
                continue;
            }
            candidates[slow + 1] = candidates[fast];
            slow++;
        }

        return Arrays.copyOf(candidates, slow + 1);
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(new int[] {2, 3, 6, 7}, 7);
        for (List l : result) {
            for (Object i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
