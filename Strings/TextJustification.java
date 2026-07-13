import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        // Stores the final justified text
        List<String> result = new ArrayList<>();

        // Pointer to the first word of the current line
        int i = 0;

        while (i < words.length) {

            // Find how many words can fit into the current line
            int j = i + 1;
            int lineLength = words[i].length();

            while (j < words.length &&
                   lineLength + words[j].length() + (j - i) <= maxWidth) {

                lineLength += words[j].length();
                j++;
            }

            int numWords = j - i;
            StringBuilder sb = new StringBuilder();

            // Case 1:
            // Last line OR only one word in the line
            // -> Left justify
            if (j == words.length || numWords == 1) {

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }

                // Pad remaining spaces at the end
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

            } else {

                // Case 2:
                // Fully justify the current line

                int totalSpaces = maxWidth - lineLength;

                // Minimum spaces between every pair of words
                int baseSpaces = totalSpaces / (numWords - 1);

                // Extra spaces are assigned from left to right
                int extraSpaces = totalSpaces % (numWords - 1);

                for (int k = i; k < j; k++) {

                    sb.append(words[k]);

                    if (k < j - 1) {

                        int spacesToApply =
                                baseSpaces + (k - i < extraSpaces ? 1 : 0);

                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            // Store the completed line
            result.add(sb.toString());

            // Move to the next line
            i = j;
        }

        return result;
    }
}
