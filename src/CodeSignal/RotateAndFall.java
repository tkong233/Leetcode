package CodeSignal;

public class RotateAndFall {
    char[][] rotateAndFall(char[][] box) {
        char[][] rotatedBox = rotateClockwise(box);
        fall(rotatedBox);
        return rotatedBox;
    }

    char[][] rotateClockwise(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        char[][] result = new char[cols][rows];
        for (int oldRow = 0; oldRow < rows; oldRow++) {
            for (int oldCol = 0; oldCol < cols; oldCol++) {
                int newRow = oldCol;
                int newCol = rows - oldRow - 1;
                result[newRow][newCol] = box[oldRow][oldCol];
            }
        }
        return result;
    }

    private void fall(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        for (int col = 0; col < cols; col++) {
            int slowRow = rows - 1;
            for (int fastRow = rows - 1; fastRow >= 0; fastRow--) {
                if (box[fastRow][col] == '.') {
                    continue;
                } else if (box[fastRow][col] == '#') {
                    box[slowRow--][col] = box[fastRow][col];
                } else {
                    while (slowRow > fastRow) {
                        box[slowRow--][col] = '.';
                    }
                    slowRow--;
                }
            }
            while (slowRow >= 0) {
                box[slowRow--][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        RotateAndFall solution = new RotateAndFall();
        solution.rotateAndFall(new char[][] {
                {'#', '#', '.', '.', '*', '.', '.'},
                {'#', '#', '#', '.', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '#', '.'}
        });
    }
}
