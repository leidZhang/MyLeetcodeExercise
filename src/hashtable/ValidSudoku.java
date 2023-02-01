package hashtable;

public class ValidSudoku {
    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".",".",".","."},
                            {"6",".",".","1","9","5",".",".","."},
                            {".","9","8",".",".",".",".","6","."},
                            {"8",".",".",".","6",".",".",".","3"},
                            {"4",".",".","8",".","3",".",".","1"},
                            {"7",".",".",".","2",".",".",".","6"},
                            {".","6",".",".",".",".","2","8","."},
                            {".",".",".","4","1","9",".",".","5"},
                            {".",".",".",".","8",".",".","7","9"}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(String[][] board) {
        boolean[] check = new boolean[10]; // hash table
        // check row
        for (int i = 0; i < 9; i++) { // row num
            for (int j = 0; j < 9; j++) { // col num
                if(board[i][j].equals(".")) continue; // skip "."
                int num = Integer.parseInt(board[i][j]);
                if (check[num]) return false; // already have a same number, so check[num] = true
                check[num] = true; // record the number into the table
            }
            check = new boolean[10]; // reset table
        }
        // check column
        for (int i = 0; i < 9; i++) { // row num
            for (int j = 0; j < 9; j++) { // col num
                if(board[j][i].equals(".")) continue; // skip "."
                int num = Integer.parseInt(board[j][i]);
                if (check[num]) return false; // already have a same number, so check[num] = true
                check[num] = true; // record the number into the table
            }
            check = new boolean[10];
        }
        // check box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if(board[i + x][j + y].equals(".")) continue; // skip "."
                        int num = Integer.parseInt(board[i + x][j + y]);
                        if (check[num]) return false; // already have a same number, so check[num] = true
                        check[num] = true; // record the number into the table
                    }
                }
                check = new boolean[10];
            }
        }

        return true;
    }
}
