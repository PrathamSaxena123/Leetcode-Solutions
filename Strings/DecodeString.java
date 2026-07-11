public class Solution {

    public String decodeString(String s) {

        // Stack to store repetition counts
        Deque<Integer> countStack = new ArrayDeque<>();

        // Stack to store previously built strings
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        // Stores the currently decoded string
        StringBuilder currentString = new StringBuilder();

        // Current repetition number
        int k = 0;

        // Traverse each character
        for (char ch : s.toCharArray()) {

            // Build multi-digit numbers
            if (Character.isDigit(ch)) {

                k = k * 10 + (ch - '0');

            }
            // Beginning of an encoded substring
            else if (ch == '[') {

                // Save the current repeat count
                countStack.push(k);

                // Save the current string built so far
                stringStack.push(currentString);

                // Start decoding a fresh substring
                currentString = new StringBuilder();

                // Reset repeat count
                k = 0;

            }
            // End of the current encoded substring
            else if (ch == ']') {

                // Number of times the substring should repeat
                int repeatTimes = countStack.pop();

                // Previous string before '['
                StringBuilder decodedString = stringStack.pop();

                // Append the decoded substring repeatedly
                while (repeatTimes > 0) {
                    decodedString.append(currentString);
                    repeatTimes--;
                }

                // Continue decoding from the combined string
                currentString = decodedString;

            }
            // Normal alphabet character
            else {

                currentString.append(ch);
            }
        }

        // Final decoded string
        return currentString.toString();
    }
}
