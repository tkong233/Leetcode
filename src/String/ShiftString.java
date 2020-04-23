package String;

public class ShiftString {
    // shift a given string to the right-hand side by n characters
    // e.g. shiftString("abcdef", 2) => "efabcd"

    String shiftString(String input, int n) {
        // assumption: array is not null
        if (input.length() <= 2) {
            return input;
        }
        char[] a = input.toCharArray();
        // step 1: reverse entire string
        reverse(a, 0, a.length - 1);

        // step 2: reverse substring [0, n] and [n + 1, a.length - 1]
        reverse(a, 0, n - 1);
        reverse(a, n, a.length - 1);
        return new String(a);
    }

    // reverse characters in a[left, right]
    void reverse(char[] a, int left, int right) {
        while (left < right) {
            swap(a, left++, right--);
        }
    }

    void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        ShiftString solution = new ShiftString();
        System.out.println(solution.shiftString("abcdef", 2));
    }
}
