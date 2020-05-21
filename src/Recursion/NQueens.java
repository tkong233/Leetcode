package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
        for a chessboard of size n*n,
        find all valid ways of putting n Queens onto the chessboard
        so that no two Queens can threat each other.
        return an array of int where each element represents the position to put
     */
    List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        nQueensHelper(result, cur, n, 0);
        return result;
    }
    // 这里没必要return result，因为直接在heap里改了传进来的object
    void nQueensHelper(List<List<Integer>> result, List<Integer> cur, int n, int row) {
        if (row == n) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < n; i++) {
            // 先check是否valid，再add！
            // recursive call完了之后要remove！
            // cur.set(index, e) 只适用于replace一个已经存在的element
            // 这里element还没被添加，不能用set，会报错。
            if (isValid(i, row, cur)) {
                cur.add(i);
                nQueensHelper(result, cur, n, row + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isValid(int position, int row, List<Integer> cur) {
        for (int i = 0; i < row; i++) {
            int otherPos = cur.get(i);
            // 两个if block里面做的事情相同，应该把两个条件合并到一个if里
            // 这里确定row比i大，就没必要用Math.abs()
            if (otherPos == position || Math.abs(otherPos - position) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens solution = new NQueens();
        List<List<Integer>> result = solution.nQueens(8);
        for (List l : result) {
            for (Object i : l) {
                System.out.print(i + " ");
                System.out.println();
            }
        }
    }
}
