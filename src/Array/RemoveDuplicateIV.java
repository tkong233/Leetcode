package Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RemoveDuplicateIV {
    /*
        Given an unsorted array, remove duplicate elements repeatedly.
        e.g. abccba => abba => aa => []
     */
    int[] removeDuplicate(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;

        while (i < input.length) {
            if (stack.isEmpty() || stack.peekFirst() != input[i]) {
                stack.offerFirst(input[i++]);
                continue;
            }

            if (input[i] == stack.peekFirst()) {
                while (i < input.length && input[i] == stack.peekFirst()) {
                    i++;
                }
                // input[i] = the first element different from top
                stack.pollFirst();
            }
        }

        int[] result = new int[stack.size()];
        copyStackToArray(result, stack);
        return result;
    }

    void copyStackToArray(int[] array, Deque<Integer> stack) {
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = stack.pollFirst();
        }
    }

    public static void main(String[] args) {
        RemoveDuplicateIV solution = new RemoveDuplicateIV();
        int[] result = solution.removeDuplicate(new int[] {3, 1, 2, 2, 2, 1, 3, 4, 5});
        System.out.println(Arrays.toString(result));
    }
}
