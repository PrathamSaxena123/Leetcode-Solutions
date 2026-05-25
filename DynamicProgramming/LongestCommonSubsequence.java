class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        // dp[i][j] =
        // length of LCS between:
        // first i chars of text1
        // first j chars of text2
        int[][] dp = new int[n + 1][m + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // Characters match
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    // Extend common subsequence
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    // Skip one character
                    // from either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Final LCS length
        return dp[n][m];
    }
}
