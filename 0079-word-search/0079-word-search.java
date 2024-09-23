class Solution {
    public boolean exist(char[][] board, String word) {
        return wordExistHelper(board, word);
    }

    private boolean wordExistHelper(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(checkBoard(board, word, i, j, board.length, board[0].length, 0, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkBoard(char[][] board, String word, int row, int col, int rowLen, int colLen, int idx, boolean[][] vis) {

        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= rowLen || col >= colLen || vis[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(idx)) {
            return false;
        }

        vis[row][col] = true;

        boolean isAnsUp = checkBoard(board, word, row-1, col, rowLen, colLen, idx+1, vis);
        boolean isAnsRight = checkBoard(board, word, row, col+1, rowLen, colLen, idx+1, vis);
        boolean isAnsDown = checkBoard(board, word, row+1, col, rowLen, colLen, idx+1, vis);
        boolean isAnsLeft = checkBoard(board, word, row, col-1, rowLen, colLen, idx+1, vis);

        vis[row][col] = false;

        return isAnsUp || isAnsDown || isAnsLeft || isAnsRight;
    }
}