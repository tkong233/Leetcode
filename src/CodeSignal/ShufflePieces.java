package CodeSignal;


public class ShufflePieces {
    private static boolean shufflePieces(int[] arr, int[][] pieces) {
        int length = 0;
        for (int i = 0; i < pieces.length; i++) {
            length += pieces[i].length;
        }
        if (length != arr.length) {
            return false;
        }
        boolean[] result = new boolean[]{false};
        dfs(arr, pieces, new boolean[pieces.length], 0, result);
        return result[0];
    }

    private static void dfs(int[] arr, int[][] pieces, boolean[] used, int index, boolean[] result) {
        if (index == arr.length) {
            result[0] = true;
            return;
        }
        if (result[0]) {
            return;
        }
        for (int i = 0; i < pieces.length; i++) {
            if (match(arr, pieces[i], index)) {
                used[i] = true;
                dfs(arr, pieces, used, index + pieces[i].length, result);
                used[i] = false;
            }
        }
    }

    private static boolean match(int[] arr, int[] piece, int start) {
        for (int i = 0; i < piece.length; i++) {
            if (start + i >= arr.length) {
                return false;
            }
            if (arr[start + i] != piece[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        shufflePieces(new int[] {1, 2, 5, 3, 6}, new int[][] {
                {5},
                {1, 2},
                {3, 6, 6},
        });
    }
}
