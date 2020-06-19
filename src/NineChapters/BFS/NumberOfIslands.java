package NineChapters.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == true) {
                    islands++;
                    BFS(grid, row, col);
                }
            }
        }

        return islands;
    }

    void BFS(boolean[][] grid, int row, int col) {
        int[] xDirection = new int[] {0, 0, -1, 1};
        int[] yDirection = new int[] {1, -1, 0, 0};

        grid[row][col] = false;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(row, col));

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate next = new Coordinate(cur.x + xDirection[i], cur.y + yDirection[i]);
                if (isValid(grid, next)) {
                    queue.offer(next);
                    grid[next.x][next.y] = false;
                }
            }
        }
    }

    boolean isValid(boolean[][] grid, Coordinate coor) {
        if (coor.x < 0 || coor.x >= grid.length || coor.y < 0 || coor.y >= grid[0].length) {
            return false;
        }
        return grid[coor.x][coor.y];
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        boolean[][] grid = new boolean[][] {
                {true, true, false, false, false},
                {false, true, false, false, true},
                {false, false, false, true, true},
                {false, false, false, false, false},
                {false, false, false, false, true}
        };
        int result = solution.numIslands(grid);  // 3
        System.out.println(result);
    }
}
