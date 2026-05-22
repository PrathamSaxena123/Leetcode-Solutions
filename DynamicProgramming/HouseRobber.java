class Solution {

    public int rob(int[] nums) {

        // Edge case:
        // Only one house
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;

        // dp[i] = maximum money
        // that can be robbed till house i
        int[] dp = new int[n];

        // Base case:
        // First house
        dp[0] = nums[0];

        // Base case:
        // Best among first two houses
        dp[1] = Math.max(nums[0], nums[1]);

        // Build DP array
        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        // Final answer
        return dp[n - 1];
    }
}
