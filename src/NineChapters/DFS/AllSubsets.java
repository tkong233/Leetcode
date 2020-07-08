package NineChapters.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);
        dfs(result, new LinkedList<Integer>(), 0, nums);
        return result;
    }

    void dfs(List<List<Integer>> result, List<Integer> cur, int index, int[] nums) {
        result.add(new LinkedList<>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[index]);
            dfs(result, cur, index + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllSubsets solution = new AllSubsets();
        List<List<Integer>> result = solution.subsets(new int[] {1, 2, 3});
        for (List l : result) {
            System.out.println(l.toString());
        }
    }
}
