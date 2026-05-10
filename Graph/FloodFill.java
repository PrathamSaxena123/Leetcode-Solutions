class Solution {

    private int[][] image;
    private int originalColor;
    private int newColor;
    private int rows;
    private int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        this.image = image;
        this.originalColor = image[sr][sc];
        this.newColor = color;

        rows = image.length;
        cols = image[0].length;

        // No need to process
        if (originalColor == newColor) {
            return image;
        }

        dfs(sr, sc);

        return image;
    }

    private void dfs(int row, int col) {

        // Out of bounds
        if (row < 0 || col < 0 ||
            row >= rows || col >= cols) {
            return;
        }

        // Different color
        if (image[row][col] != originalColor) {
            return;
        }

        // Fill color
        image[row][col] = newColor;

        // Explore 4 directions
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}
