package backtracking;

public class SukudoSol {
    public static void main(String[] args) {
        String[][] board = {{".",".","9","7","4","8",".",".","."},
                            {"7",".",".",".",".",".",".",".","."},
                            {".","2",".","1",".","9",".",".","."},
                            {".",".","7",".",".",".","2","4","."},
                            {".","6","4",".","1",".","5","9","."},
                            {".","9","8",".",".",".","3",".","."},
                            {".",".",".","8",".","3",".","2","."},
                            {".",".",".",".",".",".",".",".","6"},
                            {".",".",".","2","7","5","9",".","."}};

        solveSudoku(board);
    }

    static boolean[][] rows = new boolean[9][9];
    static boolean[][] cols = new boolean[9][9];
    static boolean[][][] boxs = new boolean[3][3][9];

    public static void solveSudoku(String[][] board) {
        // fill the existed numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].equals(".")) continue;
                int n = Integer.parseInt(board[i][j]) - 1;
                rows[i][n] = true;
                cols[j][n] = true;
                boxs[i / 3][j / 3][n] = true;
            }
        }
        // solvable ?
        dfs(board, 0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static boolean dfs(String[][] board, int x, int y) { // x: row, y: col
        if (y == 9) { // go to new row
            x++;
            y = 0;
        }
        if (x == 9) return true; // found a solution
        if (!board[x][y].equals(".")) return dfs(board, x, y + 1); // we can add a number here

        for (int i = 0; i < 9; i++) {
            if (rows[x][i] || cols[y][i] || boxs[x / 3][y / 3][i]) continue; // skip existed number
            rows[x][i] = true; cols[y][i] = true; boxs[x / 3][y / 3][i] = true;
            board[x][y] = "" + (i + 1); // add to the board
            if (dfs(board, x, y + 1)) return true;
            rows[x][i] = false; cols[y][i] = false; boxs[x / 3][y / 3][i] = false;
            board[x][y] = ".";
        }

        return false;
    }
}
