class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        
        if (col == 9) {
            return solveSudokuHelper(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solveSudokuHelper(board, row, col + 1);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;

                if (solveSudokuHelper(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == ch || board[i][c] == ch) {
                return false;
            }
        }

        int subMatrixRow = (r / 3) * 3;
        int subMatrixCol = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + subMatrixRow][j + subMatrixCol] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
