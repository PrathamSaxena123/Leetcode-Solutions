class Solution {

    public int longestPalindrome(String s) {

        // Stores characters with odd frequency seen so far
        Set<Character> set = new HashSet<>();

        // Length of longest palindrome
        int length = 0;

        for (char c : s.toCharArray()) {

            // Found a matching pair
            if (set.contains(c)) {

                set.remove(c);

                // Pair contributes 2 characters
                length += 2;
            }

            // First occurrence (currently unpaired)
            else {

                set.add(c);
            }
        }

        // If any character remains,
        // one of them can be placed in the center
        if (!set.isEmpty()) {

            length += 1;
        }

        return length;
    }
}
