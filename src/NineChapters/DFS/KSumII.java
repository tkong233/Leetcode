package NineChapters.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KSumII {
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();

        if (A == null) {
            return result;
        }
        if (A.length == 0 || k <= 0 || target <= 0) {
            result.add(cur);
            return result;
        }

        Arrays.sort(A);
        dfs(A, k, target, 0, result, cur);
        return result;
    }

    void dfs(int[] A,
             int numsRemain,
             int targetRemain,
             int index,
             List<List<Integer>> result,
             List<Integer> cur) {
        if (numsRemain == 0 && targetRemain == 0) {
            result.add(new LinkedList<>(cur));
            return;
        }
        if (numsRemain == 0 || targetRemain <= 0) {
            return;
        }

        for (int i = index; i < A.length; i++) {
            cur.add(A[i]);
            dfs(A, numsRemain - 1, targetRemain - A[i], i + 1, result, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        KSumII solution = new KSumII();
        List<List<Integer>> result = solution.kSumII(new int[] {1, 2, 3, 4}, 2, 5);
        for (List<Integer> list : result) {
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }
}
