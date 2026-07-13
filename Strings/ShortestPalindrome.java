class Solution {

    public String shortestPalindrome(String s) {

        // Handle edge cases
        if (s == null || s.length() <= 1) {
            return s;
        }

        // Reverse the original string
        String reversed = new StringBuilder(s).reverse().toString();

        // Create a combined string separated by a unique character
        // Example: "aacecaaa#aaacecaa"
        String combined = s + "#" + reversed;

        // LPS (Longest Prefix Suffix) array used in KMP
        int[] lps = new int[combined.length()];

        // Build the LPS array
        for (int i = 1; i < combined.length(); i++) {

            int j = lps[i - 1];

            // Move back until characters match
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }

            // Extend the current prefix
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        // Length of the longest palindromic prefix
        int longestPalindromePrefixLength = lps[combined.length() - 1];

        // Characters that must be added to the front
        String suffixToPrepend =
                reversed.substring(0, s.length() - longestPalindromePrefixLength);

        // Construct the shortest palindrome
        return suffixToPrepend + s;
    }
}
