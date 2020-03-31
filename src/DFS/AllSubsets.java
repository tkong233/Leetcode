package DFS;

import java.util.ArrayList;
import java.util.List;

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
//        solution.allSubsets(new char[] {'a', 'b', 'c'});
        List<String> s = solution.subSets("abc");
        System.out.println(s.toArray());
    }


    public List<String> subSets(String set) {
        List<String> solution = new ArrayList<>();
        int index = 0;
        char[] setArray = set.toCharArray();
        StringBuilder solutionPrefix = new StringBuilder();
        subSets(setArray, index, solutionPrefix, solution);
        return solution;
    }

    public void subSets(char[] set, int index, StringBuilder solutionPrefix, List<String> solution) {
        if (index == set.length) {
            solution.add(solutionPrefix.toString());
            return;
        }
        solutionPrefix.append(set[index]);
        subSets(set, index + 1, solutionPrefix, solution);
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        subSets(set, index + 1, solutionPrefix, solution);
    }
}
