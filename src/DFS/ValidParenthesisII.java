package DFS;
import java.util.*;

public class ValidParenthesisII {
    public List<String> validParentheses(int l, int m, int n) {
        Deque<Character> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        validParenthesisHelper(stack, result, new StringBuilder(), l, m, n, 2 * l + 2 * m + 2 * n);
        return result;
    }

    private void validParenthesisHelper(Deque<Character> stack, List<String> result,
                                        StringBuilder sb, int l, int m, int n, int total) {
        if (sb.length() == total) {
            result.add(sb.toString());
            return;
        }
        if (!stack.isEmpty()) {
            char prev = stack.pollFirst();
            if (prev == '(') {
                sb.append(')');
                validParenthesisHelper(stack, result, sb, l, m, n, total);
            } else if (prev == '<') {
                sb.append('>');
                validParenthesisHelper(stack, result, sb, l, m, n, total);
            } else {
                sb.append('}');
                validParenthesisHelper(stack, result, sb, l, m, n, total);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l > 0) {
            stack.offerFirst('(');
            sb.append('(');
            validParenthesisHelper(stack, result, sb, l - 1, m, n, total);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (m > 0) {
            stack.offerFirst('<');
            sb.append('<');
            validParenthesisHelper(stack, result, sb, l, m - 1, n, total);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (n > 0) {
            stack.offerFirst('{');
            sb.append('<');
            validParenthesisHelper(stack, result, sb, l, m, n - 1, total);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        ValidParenthesisII solution = new ValidParenthesisII();
        List<String> result = solution.validParentheses(1, 0, 0);
        System.out.println(result.toString());
    }
}
