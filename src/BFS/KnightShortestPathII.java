package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathII {
    private class Coordinate {
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

        int[] transitionX = new int[] {1, -1, 2, -2};
        int[] transitionY = new int[] {2, 2, 1, 1};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int s = 0; s < size; s++) {
                Coordinate cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Coordinate next = new Coordinate(cur.x + transitionX[i], cur.y + transitionY[i]);
                    if (next.x == grid.length - 1 && next.y == grid[0].length - 1) {
                        return steps;
                    }
                    if (isValid(next, grid)) {
                        queue.offer(next);
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(Coordinate c, boolean[][] grid) {
        if (c.x < 0 || c.x > grid.length - 1 || c.y < 0 || c.y > grid[0].length - 1) {
            return false;
        }

        return !grid[c.x][c.y];
    }

    public static void main(String[] args) {
        KnightShortestPathII solution = new KnightShortestPathII();
        boolean[][] grid = new boolean[][] {
            {false, true, false},
            {false, false, true},
            {false, false, false}
        };

        boolean[][] grid2 = new boolean[][] {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        int result = solution.shortestPath2(grid2);
        System.out.println(result);
    }
}
