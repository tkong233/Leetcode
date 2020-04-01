package Sort;

import java.util.Arrays;

public class RainbowSort {
    void rainbowSort(char[] input) {
        if (input == null || input.length <= 1) {
            return;
        }
        int i = 0, j = 0, k = 0, l = 0;
        while (l < input.length) {
            if (input[l] == 'd') {
                l++;
            } else if (input[l] == 'c') {
                swap(input, k++, l++);
            } else if (input[l] == 'b') {
                swap(input, k, l++);
                swap(input, j++, k++);
            } else {
                swap(input, k, l++);
                swap(input, j, k++);
                swap(input, i++, j++);
            }
        }
    }

    void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        RainbowSort solution = new RainbowSort();
        char[] input = new char[] {'a', 'c', 'c', 'd', 'a', 'b', 'b', 'a', 'd', 'c'};
        solution.rainbowSort(input);
        System.out.println(Arrays.toString(input));
    }
}
