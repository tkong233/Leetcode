package Interviews.Duolingo;

import Recursion.SpiralOrder;

public class SprintTraining {
    int sprintTraining(int n, int[] sprints) {
        if (n <= 1 || sprints == null || sprints.length == 0) {
            return n;
        }

        int[] count = new int[n + 1];
        int start = sprints[0];
        for (int i = 1; i < sprints.length; i++) {
            int cur = sprints[i];
            getSprintCount(start, cur, count);
            start = cur;
        }

        int maxVisit = 0;
        int maxVisitPoint = -1;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > maxVisit) {
                maxVisit = count[i];
                maxVisitPoint = i;
            }
        }

        return maxVisitPoint;
    }

    void getSprintCount(int p1, int p2, int[] count) {
        int start = Math.min(p1, p2);
        int end = Math.max(p1, p2);

        for (int i = start; i <= end; i++) {
            count[i] = count[i] + 1;
        }
    }

    public static void main(String[] args) {
        SprintTraining solution = new SprintTraining();
        int result = solution.sprintTraining(10, new int[] {1, 5, 10, 3});
        System.out.println(result);
    }
}
