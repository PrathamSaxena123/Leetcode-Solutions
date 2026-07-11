import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> partition(String s) {

        // Stores all valid palindrome partitions
        List<List<String>> result = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    // Generates all possible palindrome partitions
    private void backtrack(String s, int start,
                           List<String> current,
                           List<List<String>> result) {

        // If we've reached the end of the string,
        // one valid partition has been found
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting from 'start'
        for (int end = start; end < s.length(); end++) {

            // Continue only if the current substring is a palindrome
            if (isPalindrome(s, start, end)) {

                // Choose the palindrome substring
                current.add(s.substring(start, end + 1));

                // Explore the remaining string
                backtrack(s, end + 1, current, result);

                // Backtrack by removing the last chosen substring
                current.remove(current.size() - 1);
            }
        }
    }

    // Checks whether s[low...high] is a palindrome
    private boolean isPalindrome(String s, int low, int high) {

        while (low < high) {

            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }

        return true;
    }
}
