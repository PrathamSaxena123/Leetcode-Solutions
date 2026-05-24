class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // dp[i] = length of longest
        // increasing subsequence ending at i
        int[] dp = new int[n];

        // Every element is at least a subsequence of length 1
        Arrays.fill(dp, 1);

        int max = 1;

        // Fix ending point i
        for (int i = 0; i < n; i++) {

            // Check all previous elements
            for (int j = 0; j < i; j++) {

                // If increasing order is maintained
                if (nums[j] < nums[i]) {

                    // Take best possible subsequence
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update global maximum
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
