package String;

public class ReverseString {
    // method 1: iterative
//    String reverse(String input) {
//        char[] a = input.toCharArray();
//        int j = a.length - 1;
//        for (int i = 0; i < j; i++) {
//            swap(a, i, j--);
//        }
//        return new String(a);
//    }

    // method 2: recursive
    String reverse(String input) {
        char[] a = input.toCharArray();
        reverseHelper(a, 0, a.length - 1);
        return new String(a);
    }

    void reverseHelper(char[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(a, left, right);
        reverseHelper(a, left + 1, right - 1);
        // left++, right-- is wrong. will call before increment
        // ++left, --right is also correct
    }

    void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        System.out.println(solution.reverse("abcdef"));
    }
}
