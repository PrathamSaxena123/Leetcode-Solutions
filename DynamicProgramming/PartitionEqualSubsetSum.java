class Solution {

    public boolean canPartition(int[] nums) {

        // Calculate total sum
        int s = 0;

        for (int x : nums) {
            s += x;
        }

        // Odd sum can never be divided equally
        if (s % 2 == 1) {
            return false;
        }

        int n = nums.length;

        // Target subset sum
        int m = s >> 1;

        // f[i][j] =
        // whether using first i elements,
        // we can form sum j
        boolean[][] f = new boolean[n + 1][m + 1];

        // Base case:
        // sum 0 is always possible
        f[0][0] = true;

        // Build DP table
        for (int i = 1; i <= n; i++) {

            int x = nums[i - 1];

            for (int j = 0; j <= m; j++) {

                f[i][j] = f[i - 1][j] || (j >= x && f[i - 1][j - x]);
            }
        }

        // Final answer:
        // Can we form target sum?
        return f[n][m];
    }
}
