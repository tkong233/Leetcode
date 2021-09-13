package DFS;
import java.util.*;

public class AllPermutationsII {
    public List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        permutationsHelper(input.toCharArray(), result, 0);
        return result;
    }

    private void permutationsHelper(char[] input, List<String> result, int index) {
        if (index == input.length) {
            result.add(new String(input));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < input.length; i++) {
            if (used.add(input[i])) {
                swap(input, i, index);
                permutationsHelper(input, result, index + 1);
                swap(input, i, index);
            }
        }
    }

    private void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        AllPermutationsII solution = new AllPermutationsII();
        List<String> result = solution.permutations("abcadcd");
        System.out.println(result.toString());
    }
}
