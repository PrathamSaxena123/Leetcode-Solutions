public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        // Stores starting indices of all anagrams
        List<Integer> result = new ArrayList<>();

        // Edge case: invalid input or pattern longer than string
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // Frequency arrays for pattern and current window
        int[] pCounts = new int[26];
        int[] sCounts = new int[26];

        // Build frequency counts for the pattern
        // and the first window of the string
        for (int i = 0; i < p.length(); i++) {
            pCounts[p.charAt(i) - 'a']++;
            sCounts[s.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(pCounts, sCounts)) {
            result.add(0);
        }

        // Slide the window across the string
        for (int i = p.length(); i < s.length(); i++) {

            // Add the new character entering the window
            sCounts[s.charAt(i) - 'a']++;

            // Remove the character leaving the window
            sCounts[s.charAt(i - p.length()) - 'a']--;

            // Compare frequency arrays
            if (Arrays.equals(pCounts, sCounts)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
