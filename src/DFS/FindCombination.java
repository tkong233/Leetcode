package DFS;

// Print all combinations of coins that can sum up to a total value n


import java.util.Arrays;

public class FindCombination {

    void findCombination(int coins[], int sol[], int index, int total, int moneyLeft) {
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

    public static void main(String[] args) {
        FindCombination solution = new FindCombination();
        int[] coins = new int[]{25, 10, 5, 1};
        solution.findCombination(coins, 5);
    }
}