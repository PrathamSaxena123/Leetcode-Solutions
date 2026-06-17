class Solution {

    public List<List<String>> solveNQueens(int n) {

        // Stores all valid board configurations
        List<List<String>> result = new ArrayList<>();

        // Board representation
        char[][] board = new char[n][n];

        // Initialize board with empty cells
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start placing queens row by row
        backtrack(board, 0, result);

        return result;
    }

    private void backtrack(char[][] board,
                           int row,
                           List<List<String>> result) {

        // Successfully placed queens in every row
        if (row == board.length) {

            List<String> configuration = new ArrayList<>();

            for (char[] r : board) {
                configuration.add(new String(r));
            }

            result.add(configuration);
            return;
        }

        // Try placing a queen in every column
        for (int col = 0; col < board.length; col++) {

            if (!isSafe(board, row, col)) {
                continue;
            }

            // Choose
            board[row][col] = 'Q';

            // Explore next row
            backtrack(board, row + 1, result);

            // Backtrack
            board[row][col] = '.';
        }
    }

    private boolean isSafe(char[][] board,
                           int row,
                           int col) {

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
