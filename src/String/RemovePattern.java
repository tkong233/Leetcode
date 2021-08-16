package String;

public class RemovePattern {
    public String remove(String input, String t) {
        // Write your solution here

        // input = bcabcababc
        // pattern = abc
        //                s        f
        //           b c a b c a b a b c
        // output = b c a b
        int fast = 0;
        int slow = 0;
        char[] array = input.toCharArray();
        while (slow < array.length && fast < array.length) {
            if (array[fast] == t.charAt(0)) {
                fast = checkPattern(array, t, fast);
            }
            if (fast < array.length) {
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }

    // return original pos if substring starting at pos doesn't match pattern
    // return pos after pattern ends if pattern matched
    private int checkPattern(char[] array, String pattern, int pos) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pos + i > array.length - 1) {
                return pos;
            }
            if (array[pos + i] != pattern.charAt(i)) {
                return pos;
            }
        }
        return pos + pattern.length();
    }

    public static void main(String[] args) {
        RemovePattern solution = new RemovePattern();
        String result = solution.remove("aaabcaaba", "abc");
        System.out.println(result);
    }
}
