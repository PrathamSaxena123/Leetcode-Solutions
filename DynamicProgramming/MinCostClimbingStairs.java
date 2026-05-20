class SolutionStandard {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        // dp[i] = minimum cost
        // required to reach step i
        int[] dp = new int[n];

        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Build DP table
        for (int i = 2; i < n; i++) {

            // To reach current step,
            // either come from:
            // i-1 or i-2
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // Final top lies beyond last index
        // So answer is min of:
        // last step or second last step
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
