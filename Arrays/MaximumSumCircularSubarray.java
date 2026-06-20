class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        // Stores the sum of all elements
        int totalSum = 0;

        // Variables for Kadane's algorithm (maximum subarray)
        int currMax = 0;
        int maxSum = nums[0];

        // Variables for minimum subarray
        int currMin = 0;
        int minSum = nums[0];

        // Traverse the array once
        for (int num : nums) {

            totalSum += num;

            // Maximum subarray ending at current position
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            // Minimum subarray ending at current position
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        // If all elements are negative,
        // totalSum - minSum would incorrectly become 0
        if (maxSum < 0) {
            return maxSum;
        }

        // Answer is either:
        // 1. Normal maximum subarray
        // 2. Circular maximum = totalSum - minimum subarray
        return Math.max(maxSum, totalSum - minSum);
    }
}
