class Solution {

    public int maxSubArray(int[] nums) {

        // Edge case:
        // Empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Current best subarray ending at current index
        int currentSum = nums[0];

        // Overall maximum subarray sum found so far
        int maxSum = nums[0];

        // Traverse remaining elements
        for (int i = 1; i < nums.length; i++) {

            // Either:
            // 1. Start a new subarray from nums[i]
            // 2. Extend the previous subarray
            currentSum = Math.max(
                nums[i],
                currentSum + nums[i]
            );

            // Update global maximum
            maxSum = Math.max(
                maxSum,
                currentSum
            );
        }

        return maxSum;
    }
}
