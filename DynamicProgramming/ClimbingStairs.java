class Solution {

    public int climbStairs(int n) {

        // Base cases
        if (n <= 2) {
            return n;
        }

        // dp[i] = number of ways
        // to reach step i
        int[] dp = new int[n + 1];

        // 1 way to reach step 1
        dp[1] = 1;

        // 2 ways to reach step 2
        dp[2] = 2;

        // Build DP table
        for (int i = 3; i <= n; i++) {

            // Either:
            // come from i-1
            // or come from i-2
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
