class Solution {

    public String minWindow(String s, String t) {

        // Edge case: impossible to form the window
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters required from t
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        // Sliding window pointers
        int start = 0;
        int end = 0;

        // Stores the length and starting index of the best window
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // Number of characters still needed to form a valid window
        int count = t.length();

        while (end < s.length()) {

            // Expand the window by including s[end]
            char cEnd = s.charAt(end);

            // This character was needed
            if (map[cEnd] > 0) {
                count--;
            }

            // Decrease its required frequency
            map[cEnd]--;
            end++;

            // Try shrinking the window while it remains valid
            while (count == 0) {

                // Update the smallest valid window found so far
                if (end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }

                // Remove the leftmost character
                char cStart = s.charAt(start);

                map[cStart]++;

                // If this character becomes required again,
                // the window is no longer valid
                if (map[cStart] > 0) {
                    count++;
                }

                start++;
            }
        }

        // Return the smallest valid window if found
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}
