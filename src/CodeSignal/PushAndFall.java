package CodeSignal;

public class PushAndFall {
    char[][] pushAndFall(char[][] box) {
        pushToRight(box);
        fall(box);
        return box;
    }

    private void pushToRight(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        for (int row = 0; row < rows; row++) {
            int slowCol = cols - 1;
            for (int fastCol = cols - 1; fastCol >= 0; fastCol--) {
                if (box[row][fastCol] == '.') {
                    continue;
                } else if (box[row][fastCol] == '#') {
                    box[row][slowCol--] = box[row][fastCol];
                } else {
                    while (slowCol > fastCol) {
                        box[row][slowCol--] = '.';
                    }
                    slowCol--;
                }
            }
            while (slowCol >= 0) {
                box[row][slowCol--] = '.';
            }
        }
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
        PushAndFall solution = new PushAndFall();
        solution.pushAndFall(new char[][] {
                {'#', '#', '.', '.', '*', '.', '.'},
                {'#', '#', '#', '.', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '#', '.'}
        });
    }
}
