package NineChapters.DFS;
import java.util.*;

public class TravelingSalesmanProblem {
    public int minCost(int n, int[][] roads) {
        int[] result = new int[1];
        if (n == 0 || roads == null || roads.length == 0 || roads[0].length == 0) {
            return result[0];
        }

        result[0] = Integer.MAX_VALUE;
        int[][] graph = new int[n + 1][n + 1];
        constructGraph(graph, n, roads);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        dfs(n, 1, graph, visited, 0, result);
        return result[0];
    }

    void dfs(int n,
             int currentNode,
             int[][] graph,
             Set<Integer> visited,
             int cost,
             int[] result) {
        if (visited.size() == n) {
            result[0] = Math.min(result[0], cost);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            int currentCost = graph[i][currentNode];
            if (currentCost == Integer.MAX_VALUE) {
                continue;
            }
            visited.add(i);
            dfs(n, i, graph, visited, cost + currentCost, result);
            visited.remove(i);
        }
    }

    // graph[i][j] = cost of path from i to j
    // graph[i][j] = Integer.MAX_VALUE if there isn't a path between i and j
    void constructGraph(int[][] graph, int n, int[][] roads) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < roads.length; i++) {
            int node1 = roads[i][0];
            int node2 = roads[i][1];
            int cost = roads[i][2];

            graph[node1][node2] = Math.min(graph[node1][node2], cost);
            graph[node2][node1] = Math.min(graph[node2][node1], cost);
        }
    }

    public static void main(String[] args) {
        TravelingSalesmanProblem solution = new TravelingSalesmanProblem();
        int n = 3;
        int[][] roads = new int[][] {
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 3}
        };

        int result = solution.minCost(n, roads);

        System.out.println(result);
    }
}
