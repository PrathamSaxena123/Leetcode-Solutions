/**
 * Problem: Longest Substring Without Repeating Characters
 * Platform: LeetCode
 * Difficulty: Medium
 * Topic: Sliding Window
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset))
 */

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // If duplicate character is found, shrink the window
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the set
            set.add(s.charAt(right));

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
