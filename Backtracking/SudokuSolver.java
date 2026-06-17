class Solution {

    public void solveSudoku(char[][] board) {

        // Start solving the board using backtracking
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {

        // Traverse every cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Skip already filled cells
                if (board[row][col] != '.') {
                    continue;
                }

                // Try digits 1 to 9
                for (char num = '1'; num <= '9'; num++) {

                    // Check if placing this digit is valid
                    if (!isValid(board, row, col, num)) {
                        continue;
                    }

                    // Choose
                    board[row][col] = num;

                    // Explore
                    if (backtrack(board)) {
                        return true;
                    }

                    // Backtrack
                    board[row][col] = '.';
                }

                // No valid digit can be placed here
                return false;
            }
        }

        // Entire board successfully filled
        return true;
    }

    private boolean isValid(char[][] board,
                            int row,
                            int col,
                            char num) {

        for (int i = 0; i < 9; i++) {

            // Check current row
            if (board[row][i] == num) {
                return false;
            }

            // Check current column
            if (board[i][col] == num) {
                return false;
            }

            // Check 3 × 3 subgrid
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }

        return true;
    }
}
