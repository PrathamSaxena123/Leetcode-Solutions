class Solution {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // dp[i][j] =
        // minimum operations needed
        // to convert:
        // first i chars of word1
        // into first j chars of word2
        int[][] dp = new int[n + 1][m + 1];

        // -------------------------
        // Base Cases
        // -------------------------

        // Convert word1 -> empty string
        // Need i deletions
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // Convert empty string -> word2
        // Need j insertions
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // -------------------------
        // Build DP table
        // -------------------------
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // Characters already match
                if (word1.charAt(i - 1) ==
                    word2.charAt(j - 1)) {

                    // No operation needed
                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Insert operation
                    int insert = dp[i][j - 1];

                    // Delete operation
                    int delete = dp[i - 1][j];

                    // Replace operation
                    int replace = dp[i - 1][j - 1];

                    // Take minimum among all operations
                    dp[i][j] =
                        1 + Math.min(
                                insert,
                                Math.min(delete, replace)
                            );
                }
            }
        }

        // Final minimum operations
        return dp[n][m];
    }
}
