package Sort;

import java.util.Arrays;

public class AlternatingNumbers {
    void alternatingNumbers(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }
        // i = index of the first positive number
        int i = partition(input);
        int j = 1;
        while (i < input.length && j < input.length && input[j] < 0) {
            swap(input, j, i);
            j += 2;
            i++;
        }
    }

    int partition(int[] input) {
        int i = 0, j = input.length - 1;
        while (i <= j) {
            if (input[i] < 0) {
                i++;
            } else if (input[j] > 0) {
                j--;
            } else {
                swap(input, i++, j--);
            }
        }
        return i;
    }

    void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        AlternatingNumbers solution = new AlternatingNumbers();
        int[] input = new int[] {1, -2, -3, -4, 3, -3, -2, 4, 5, -1, -1, -1, -4, -5};
        solution.alternatingNumbers(input);
        System.out.println(Arrays.toString(input));
    }
}
