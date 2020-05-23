package Recursion;

public class ReverseStringRecursive {
    String reverse(String input) {
        char[] a = input.toCharArray();
        reverseHelper(a, 0, a.length - 1);
        return new String(a);
    }

    // reverse characters in a[left, right]
    void reverseHelper(char[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(a, left, right);
        reverseHelper(a, left + 1, right - 1);
    }
    void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        ReverseStringRecursive solution = new ReverseStringRecursive();
        String result = solution.reverse("abcd");
        System.out.println(result);
    }
}
