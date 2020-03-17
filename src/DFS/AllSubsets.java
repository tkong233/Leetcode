package DFS;

public class AllSubsets {

    void allSubsets(char[] input) {
        allSubsetsHelper(input, 0, new StringBuilder());
    }

    void allSubsetsHelper(char[] input, int index, StringBuilder solutionPrefix) {
        if (index == input.length) {
            System.out.println(solutionPrefix);
            return;
        }

        solutionPrefix.append(input[index]);
        allSubsetsHelper(input, index + 1, solutionPrefix);
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        allSubsetsHelper(input, index + 1, solutionPrefix);
    }

    public static void main(String[] args) {
        AllSubsets solution = new AllSubsets();
        solution.allSubsets(new char[] {'a', 'b', 'c'});
    }

}
