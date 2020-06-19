package NineChapters.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathI {
    int[] X_DIRECTION = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
    int[] Y_DIRECTION = new int[] {2, -2, 2, -2, 1, -1, 1, -1};

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }

        if (grid[source.x][source.y] == true || grid[destination.x][destination.y] == true) {
            return -1;
        }

        int length = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        grid[source.x][source.y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int j = 0; j < size; j++) {
                Point cur = queue.poll();
                for (int i = 0; i < 7; i++) {
                    Point next = new Point(cur.x + X_DIRECTION[i], cur.y + Y_DIRECTION[i]);
                    if (next.x == destination.x && next.y == destination.y) {
                        return length;
                    }
                    if (!isValid(grid, next)) {
                        continue;
                    }
                    queue.offer(next);
                    grid[next.x][next.y] = true;
                }
            }
        }

        return -1;
    }

    boolean isValid(boolean[][] grid, Point point) {
        if (point.x < 0 || point.x >= grid.length || point.y < 0 || point.y >= grid[0].length) {
            return false;
        }
        return !grid[point.x][point.y];
    }
}
