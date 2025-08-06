package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode51 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(chessboard,0,n);
        return result;
    }

    private void backtracking(char[][] chessboard, int row, int n) {
        if (row == n) {
            result.add(Array2List(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row,i,n,chessboard)){
                chessboard[row][i] = 'Q';
                backtracking(chessboard,row+1,n);
                chessboard[row][i] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 因为backtracking函数中，棋盘的一行只选一个Q，所以无需进行行的检查

        // 检查列,只检查该位置同一列的上面的元素
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查主对角线，左上到右下
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查副对角线，右上到左下
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
