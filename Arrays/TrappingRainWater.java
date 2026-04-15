/**
 * Problem: Trapping Rain Water
 * Platform: LeetCode
 * Problem Number: 42
 * Difficulty: Hard
 * Topic: Arrays, Two Pointers
 *
 * Description:
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 *
 * Approach: Two-Pointer Technique
 * - Initialize two pointers at the beginning and end of the array.
 * - Maintain two variables: leftMax and rightMax to store the maximum heights
 *   encountered from the left and right sides.
 * - Move the pointer with the smaller height inward:
 *      • If height[left] < height[right], process the left side.
 *      • Otherwise, process the right side.
 * - The trapped water at each step is determined by the difference between
 *   the current maximum boundary and the height at that pointer.
 *
 * Example:
 * Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int trap(int[] height) {
        // Edge case: if the array is null or too small, no water can be trapped
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;                      // Pointer starting from the left
        int right = height.length - 1;     // Pointer starting from the right
        int leftMax = 0;                   // Maximum height to the left
        int rightMax = 0;                  // Maximum height to the right
        int trappedWater = 0;              // Total water trapped

        // Traverse the array using two pointers
        while (left < right) {
            // If the left height is smaller, process the left side
            if (height[left] < height[right]) {
                // Update leftMax or calculate trapped water
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++; // Move the left pointer inward
            } else {
                // Update rightMax or calculate trapped water
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--; // Move the right pointer inward
            }
        }

        return trappedWater;
    }
}
