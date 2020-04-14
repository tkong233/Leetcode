package String;

public class RemoveSpace {
    String removeSpace(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        char[] a = input.toCharArray();
        int slow = 0;
        for (int i = 0; i < a.length; i++) {  // i is fast pointer
            // note here we make use of java short circuit
            // once slow == 0, java won't evaluate a[slow - 1]
            // in this way, we avoid index out of bound error
            if (a[i] == ' ' && (slow == 0 || a[slow - 1] == ' ')) {
                continue;
            }
        }
        // post processing
        if (slow != 0 && a[slow - 1] == ' ') {
            slow--;
        }
        return new String(a, 0, slow);
    }

    public static void main (String[] args) {
        RemoveSpace solution = new RemoveSpace();
        System.out.println(solution.removeSpace("  abc  de   "));
    }
}
