class Solution {

    public String reverseWords(String s) {

        // Convert the input string into a character array
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Remove leading and trailing spaces
        int left = 0;
        int right = n - 1;

        while (left <= right && chars[left] == ' ') {
            left++;
        }

        while (left <= right && chars[right] == ' ') {
            right--;
        }

        // Build a cleaned string with only single spaces between words
        StringBuilder sb = new StringBuilder();

        while (left <= right) {

            if (chars[left] != ' ') {
                sb.append(chars[left]);
            }
            // Add only one space between consecutive words
            else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }

            left++;
        }

        // Convert the cleaned string into a character array
        char[] cleaned = sb.toString().toCharArray();
        int len = cleaned.length;

        // Reverse the entire string
        reverse(cleaned, 0, len - 1);

        // Reverse each individual word
        int start = 0;

        for (int end = 0; end < len; end++) {

            if (cleaned[end] == ' ') {

                reverse(cleaned, start, end - 1);
                start = end + 1;

            } else if (end == len - 1) {

                reverse(cleaned, start, end);
            }
        }

        // Return the final reversed sentence
        return new String(cleaned);
    }

    // Helper function to reverse characters between two indices
    private void reverse(char[] arr, int i, int j) {

        while (i < j) {

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}
