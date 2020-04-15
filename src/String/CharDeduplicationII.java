package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class CharDeduplicationII {
    String charDeduplication(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] a = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty()) {
                stack.offerFirst(a[i]);
            } else {
                if (stack.peekFirst() == a[i]) {
                    stack.pollFirst();
                } else {
                    stack.offerFirst(a[i]);
                }
            }
        }
        // 过去错误：注意这里每次从stack中poll一个element出来，stack size会随之变化
        int size = stack.size();
        for (int i = size - 1; i >=0; i--) {
            a[i] = stack.pollFirst();
        }
        return new String(a, 0, size);
    }

    public static void main(String[] args) {
        CharDeduplicationII solution = new CharDeduplicationII();
        System.out.println(solution.charDeduplication("abbacaaa"));
    }
}
