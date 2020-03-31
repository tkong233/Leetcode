package DFS;

import java.util.Arrays;

public class AllPermutation {

    void allPermutation(char[] input, int index) {
        if (index == input.length) {
            System.out.print(Arrays.toString(input));
            return;
        }
        for (int i = index; i < input.length; i++) {
            swap(input, index, i);
            allPermutation(input, index + 1);
            swap(input, index, i);
        }
    }

    void allPermutation(char[] input) {
        allPermutation(input, 0);
    }

    void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void main(String[] args) {
        AllPermutation solution = new AllPermutation();
        char[] input = new char[] {'a', 'b', 'c'};
        solution.allPermutation(input);
    }
}
