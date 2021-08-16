package DFS;

import java.util.*;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        Map<Integer, Set<String>> result = new HashMap<>();
        dfs(s, 0, 0, 0, 0, new StringBuilder(), result);
        int minEdits = Integer.MAX_VALUE;
        Set<String> validStrings = null;
        for (Map.Entry<Integer, Set<String>> entry : result.entrySet()) {
            int edits = entry.getKey();
            if (edits < minEdits) {
                validStrings = entry.getValue();
                minEdits = edits;
            }
        }
        return validStrings == null ? new ArrayList<>() : new ArrayList<>(validStrings);
    }

    private void dfs(String s, int index, int edits, int left, int right, StringBuilder solutionPrefix, Map<Integer, Set<String>> result) {
        if (index == s.length() && left == right) {
            Set<String> set = result.getOrDefault(edits, new HashSet<>());
            set.add(new String(solutionPrefix));
            result.put(edits, set);
            return;
        } else if (index == s.length()) {
            return ;
        }
        char cur = s.charAt(index);
        if (cur == '(') {
            // add (
            solutionPrefix.append(cur);
            dfs(s, index + 1, edits, left + 1, right, solutionPrefix, result);
            solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
            // delete (
            dfs(s, index + 1, edits + 1, left, right, solutionPrefix, result);
        } else if (cur == ')') {
            if (left > right) {
                // add )
                solutionPrefix.append(cur);
                dfs(s, index + 1, edits, left, right + 1, solutionPrefix, result);
                solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
            }
            // delete )
            dfs(s, index + 1, edits + 1, left, right, solutionPrefix, result);
        } else {
            solutionPrefix.append(cur);
            dfs(s, index + 1, edits, left, right, solutionPrefix, result);
            solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParenthesis solution = new RemoveInvalidParenthesis();
        List<String> result = solution.removeInvalidParentheses("()())()");
        System.out.println("results:");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
