package DFS;

public class ValidParen {
    // n stores the pairs of "()" provided. so total recursion level = 2*n
    // l stores the number of "(" added so far
    // r stores the number of ")" added so far
    // solutionPrefix stores solution so far

    void validParen(int n, int l, int r, StringBuilder solutionPrefix) {
        if (l == n && r == n) {
            System.out.println(solutionPrefix); // base case
            return;
        }

        // case 1: add '(' on this level
        if (l < n) {
            solutionPrefix.append('(');
            validParen(n, l + 1, r, solutionPrefix);
            solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        }

        // case 2: add ')' on this level
        if (r < l) {
            solutionPrefix.append(')');
            validParen(n, l, r + 1, solutionPrefix);
            solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        }
    }

    void validParen(int n) {
        validParen(n, 0, 0, new StringBuilder());
    }

    public static void main(String[] args) {
        ValidParen solution = new ValidParen();
        solution.validParen(2);
    }
}
