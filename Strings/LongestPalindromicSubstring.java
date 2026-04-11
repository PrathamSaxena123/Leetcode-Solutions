import java.util.Scanner;

/**
 * Program: Longest Palindromic Substring
 * Platform: LeetCode (adapted for user input)
 * Difficulty: Medium
 * Topic: Strings, Two Pointers (Expand Around Center)
 *
 * Description:
 * This program finds the longest palindromic substring in a given string.
 * A palindrome is a string that reads the same forward and backward.
 *
 * Approach:
 * - For each character in the string, treat it as the center of a palindrome.
 * - Expand around the center to check for:
 *      1. Odd-length palindromes (single center).
 *      2. Even-length palindromes (two-character center).
 * - Keep track of the start and end indices of the longest palindrome found.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Main {

    /**
     * Finds the longest palindromic substring in the given string.
     *
     * @param s The input string.
     * @return The longest palindromic substring.
     */
    public static String longestPalindrome(String s) {
        // Edge case: If the string is null or empty, return an empty string
        if (s == null || s.length() < 1) return "";

        int start = 0; // Starting index of the longest palindrome
        int end = 0;   // Ending index of the longest palindrome

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {

            // Length of the longest odd-length palindrome centered at index i
            int len1 = expandFromCenter(s, i, i);

            // Length of the longest even-length palindrome centered between i and i+1
            int len2 = expandFromCenter(s, i, i + 1);

            // Take the maximum of the two lengths
            int len = Math.max(len1, len2);

            // Update the start and end indices if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2; // Calculate new start index
                end = i + len / 2;         // Calculate new end index
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    /**
     * Expands around the given center and returns the length of the palindrome.
     *
     * @param s     The input string.
     * @param left  The left pointer of the center.
     * @param right The right pointer of the center.
     * @return The length of the palindromic substring.
     */
    private static int expandFromCenter(String s, int left, int right) {
        // Expand while the characters at left and right are equal
        // and the indices remain within the bounds of the string
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // After the loop, left and right have moved one step beyond
        // the palindrome boundaries, so subtract 1 from the length
        return right - left - 1;
    }

    /**
     * Main method to execute the program.
     * Accepts user input and displays the longest palindromic substring.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        // Find the longest palindromic substring
        String result = longestPalindrome(input);

        // Display the result
        if (result.isEmpty()) {
            System.out.println("No palindrome found.");
        } else {
            System.out.println("Longest Palindromic Substring: " + result);
            System.out.println("Length: " + result.length());
        }

        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
