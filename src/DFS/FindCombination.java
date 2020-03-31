package DFS;

// Print all combinations of coins that can sum up to a total value n


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCombination {

    void findCombination(int[] coins, int[] sol, int index, int total, int moneyLeft) {
        if (index == coins.length - 1) {
            // assume the smallest coin value is 1
            sol[index] = moneyLeft;
            System.out.print(Arrays.toString(sol));
            return;
        }

        for (int i = 0; i <= moneyLeft / coins[index]; i++) {
            sol[index] = i;
            findCombination(coins, sol, index + 1, total, moneyLeft - i * coins[index]);
        }
    }

    // each entry of coins[] specify a provided coin value
    void findCombination(int coins[], int total) {
        int sol[] = new int[coins.length];
        findCombination(coins, sol, 0, total, total);
    }

    public List<List<Integer>> combinations(int target, int[] coins) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        if (target >= 0 && coins != null) {
            combinations(target, coins, 0, target, cur, solution);
        }
        return solution;
    }

    public void combinations(int target, int[] coins, int index, int moneyLeft, List<Integer> cur, List<List<Integer>> solution) {
        if (index == coins.length) {
            if (moneyLeft == 0) {
                solution.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        for (int i = 0; i <= moneyLeft / coins[index]; i++) {
            cur.add(i);
            combinations(target, coins, index + 1, moneyLeft - coins[index] * i, cur, solution);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        FindCombination solution = new FindCombination();
        int[] coins = new int[]{5, 1};
//        List<Integer> is = new ArrayList<>();
//        is.add(1);
//        is.add(2);
//        List<List<Integer>> s = new ArrayList<>();
//        s.add(is);

        List<List<Integer>> s = solution.combinations(5, coins);

        System.out.println("solutions: ");
        System.out.println(s.size());
        for (List<Integer> l: s){
            for(int i: l) {
                System.out.print(i + " ");
            }
        }
    }
}