package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    static List<List<String>> res = new ArrayList<>();
    static List<String> board = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        for (int i=0; i<n; i++) { // init board
            String s = "";
            for (int j=0; j<n; j++) {
                s += '.';
            }
            board.add(s);
        }
        boolean[][] queens = new boolean[n][n]; // init hashtable
        backtracking(n, 0, queens);
        return res;
    }

    public static void backtracking(int n, int row, boolean[][] queens) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int i=0; i<n; i++) { // col
            if (isValid(row, i, queens)) { // trying to put a queen in new row
                repalce(i, row, 'Q');
                queens[row][i] = true;
                backtracking(n, row + 1, queens);
                queens[row][i] = false;
                repalce(i, row, '.');
            }
        }
    }

    public static boolean isValid(int row, int col, boolean[][] queens) {
        // we only have to care about queens in the previous rows
        for (int i=row-1, j=col; i>=0; i--) { // vertical up
            if (queens[i][j] == true) return false;
        }
        for(int i=row-1, j=col-1;i>=0 && j>=0; i--, j--) {
            if (queens[i][j]==true) return false; // diagonal left
        }
        for(int i=row-1, j=col+1;i>=0 && j<queens.length; i--, j++) { //diagonal right
            if (queens[i][j]== true ) return false;
        }

        return true;
    }

    public static void repalce(int col, int row, char c) {
        char[] temp = board.get(row).toCharArray();
        temp[col] = c; String s = new String(temp);
        board.set(row, s);
    }
}
