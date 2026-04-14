/**
 * Problem: Merge Sorted Array
 * Platform: LeetCode
 * Problem Number: 88
 * Difficulty: Easy
 * Topic: Arrays, Two Pointers
 *
 * Description:
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
 * as one sorted array. The first array nums1 has a size of m + n, where
 * the first m elements denote the valid elements and the last n elements
 * are set to 0 and should be ignored. The array nums2 has n elements.
 *
 * Approach:
 * - Use two pointers starting from the end of the valid portions of nums1 and nums2.
 * - Compare the elements and place the larger one at the end of nums1.
 * - Continue this process until all elements of nums2 are merged.
 * - This ensures an in-place merge without using extra space.
 *
 * Example:
 * Input: nums1 = [1,2,3,0,0,0], m = 3
 *        nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the last valid element in nums1
        int i = m - 1;

        // Pointer for the last element in nums2
        int j = n - 1;

        // Pointer for the last position in nums1
        int k = m + n - 1;

        // Merge arrays from the end to avoid overwriting elements in nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If any elements remain in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
