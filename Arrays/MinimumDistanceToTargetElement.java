/**
 * Problem: Minimum Distance to the Target Element
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: Arrays, Linear Search
 *
 * Description:
 * Given an integer array nums, an integer target, and an integer start,
 * return the minimum distance between the start index and any index i
 * such that nums[i] == target. It is guaranteed that at least one such
 * index exists.
 *
 * Approach:
 * - Traverse the array once.
 * - Whenever the target element is found, compute the absolute distance
 *   between the current index and the given start index.
 * - Maintain the minimum of these distances.
 * - Return the minimum distance after completing the traversal.
 *
 * Example:
 * Input: nums = [1,2,3,4,5], target = 5, start = 3
 * Output: 1
 * Explanation: The target 5 is at index 4, and |4 - 3| = 1.
 *
 * Time Complexity: O(n)
 *   - We traverse the array once.
 *
 * Space Complexity: O(1)
 *   - Only a few variables are used; no additional space is required.
 */

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        // Initialize the minimum distance with the maximum possible value
        int minDistance = Integer.MAX_VALUE;

        // Iterate through the array to find occurrences of the target
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element matches the target
            if (nums[i] == target) {
                // Calculate the absolute distance from the start index
                int distance = Math.abs(i - start);

                // Update the minimum distance if a smaller one is found
                minDistance = Math.min(minDistance, distance);
            }
        }

        // Return the minimum distance found
        return minDistance;
    }
}
