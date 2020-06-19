package NineChapters.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathII {
    public class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] xDirection = new int[] {1, -1, 2, -2};
        int[] yDirection = new int[] {2, 2, 1, 1};
        int step = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        queue.offer(new Coordinate(-1, -1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                return step - 1;
            }
            if (cur.x == -1 && cur.y == -1) {
                step++;
                continue;
            }

            boolean newLevel = false;
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + xDirection[i];
                int newY = cur.y + yDirection[i];
                if (isValid(grid, visited, newX, newY)) {
                    queue.offer(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                    newLevel = true;
                }
            }
            if(newLevel) {
                queue.offer(new Coordinate(-1, -1));
            }
        }

        return -1;
    }

    boolean isValid(boolean[][] grid, boolean[][] visited, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }

        if (visited[x][y] == true) {
            return false;
        }

        if (grid[x][y] == true) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        KnightShortestPathII solution = new KnightShortestPathII();
        int result = solution.shortestPath2(new boolean[][] {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        });

        System.out.println(result);  // 3: 00, 21, 02, 23
    }
}
