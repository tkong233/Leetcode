package String;

public class CharDeduplicationI {
    String charDeduplication(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] a = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast < a.length; fast++) {
            if (a[fast] != a[slow - 1]) {
                a[slow++] = a[fast];
            }
        }
        return new String(a, 0, slow);
    }

    public static void main(String[] args) {
        CharDeduplicationI solution = new CharDeduplicationI();
        System.out.println(solution.charDeduplication("aaabbdddcsgkko"));
    }
}
