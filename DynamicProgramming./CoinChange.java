class Solution {

    public int coinChange(int[] coins, int amount) {

        // dp[i] = minimum coins needed
        // to make amount i
        int[] dp = new int[amount + 1];

        // Initialize with impossible large value
        Arrays.fill(dp, amount + 1);

        // Base case:
        // 0 coins needed for amount 0
        dp[0] = 0;

        // Build DP array
        for (int i = 1; i <= amount; i++) {

            // Try every coin
            for (int coin : coins) {

                // Check if current coin is usable
                if (i - coin >= 0) {

                    // Either:
                    // keep previous answer
                    // or use current coin
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If still impossible -> return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
