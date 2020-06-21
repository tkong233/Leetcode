package NineChapters.BFS;

import java.util.*;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org == null || seqs == null) {
            return false;
        }
        if (seqs.length == 0 || seqs[0].length == 0) {
            return org.length == 0;
        }

        Map<Integer, Set<Integer>> degreeMap = getDegreeMap(seqs);
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : degreeMap.entrySet()) {
            if (entry.getValue().size() == 0) {
                queue.offer(entry.getKey());
            }
        }


        while (!queue.isEmpty()) {
            if (queue.size() > 1 || queue.size() == 0) {
                return false;
            }
            int cur = queue.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : degreeMap.entrySet()) {
                Set<Integer> set = entry.getValue();
                if (set.contains(cur)) {
                    set.remove(cur);
                    if (set.size() == 0) {
                        queue.offer(entry.getKey());
                    }
                }
            }
        }

        return true;
    }

    Map<Integer, Set<Integer>> getDegreeMap(int[][] seq) {
        Map<Integer, Set<Integer>> degreeMap = new HashMap<>();

        for (int i = 0; i < seq.length; i++) {
            for (int j = 0; j < seq[i].length; j++) {
                int cur = seq[i][j];
                Set<Integer> set = degreeMap.getOrDefault(cur, new HashSet<Integer>());
                for (int k = 0; k < j; k++) {
                    set.add(seq[i][k]);
                }
                degreeMap.put(cur, set);
            }
        }

        return degreeMap;
    }

    public boolean sequenceReconstruction2(int[] org, int[][] seqs) {
        if (org == null || seqs == null) {
            return false;
        }

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> order = new HashMap<>();

        for (int[] seq : seqs) {
            for (int num : seq) {
                inDegree.put(num, 0);
                order.put(num, new HashSet<>());
            }
        }

        if (order.size() != org.length) {
            return false;
        }

        if (!getOrderAndInDegree(inDegree, order, org.length, seqs)) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        int count = 0;
        while (queue.size() == 1) {
            int cur = queue.poll();
            if (cur != org[count]) {
                return false;
            }
            for (int neighbor : order.get(cur)) {
                int neighborInDegree = inDegree.get(neighbor) - 1;
                inDegree.put(neighbor, neighborInDegree);
                if (neighborInDegree == 0) {
                    queue.offer(neighbor);
                }
            }
            count++;
        }

        return count == org.length;
    }

    boolean getOrderAndInDegree(Map<Integer, Integer> inDegree, Map<Integer, Set<Integer>> order, int n, int[][] seqs) {
        for (int[] seq : seqs) {
            if (seq.length >= 1 && (seq[0] < 1 || seq[0] > n)) {
                return false;
            }
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] < 1 || seq[i] > n) {
                    return false;
                }
                if (order.get(seq[i - 1]).add(seq[i])) {
                    inDegree.put(seq[i], inDegree.get(seq[i]) + 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction solution = new SequenceReconstruction();
        int[] org = new int[] {4, 1, 5, 2, 6, 3};
        int[][] seq = new int[][] {
                {5, 2, 6, 3},
                {4, 1, 5, 2}
        };

        boolean result = solution.sequenceReconstruction(org, seq);
        boolean result2 = solution.sequenceReconstruction2(org, seq); // true
        System.out.println(result2);
    }
}
