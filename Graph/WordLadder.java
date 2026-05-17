class Solution {

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        // Store words for O(1) lookup
        Set<String> words = new HashSet<>(wordList);

        // BFS queue
        Queue<String> q = new ArrayDeque<>();

        // Start BFS from beginWord
        q.offer(beginWord);

        // Initial transformation length
        int ans = 1;

        // BFS traversal
        while (!q.isEmpty()) {

            // Moving to next level
            ++ans;

            // Process current BFS level
            for (int i = q.size(); i > 0; --i) {

                String s = q.poll();

                // Convert word to char array
                // for character replacement
                char[] chars = s.toCharArray();

                // Try changing every character
                for (int j = 0; j < chars.length; ++j) {

                    // Store original character
                    char ch = chars[j];

                    // Replace with all alphabets
                    for (char k = 'a'; k <= 'z'; ++k) {

                        chars[j] = k;

                        String t = new String(chars);

                        // Ignore invalid words
                        if (!words.contains(t)) {
                            continue;
                        }

                        // Reached target word
                        if (endWord.equals(t)) {
                            return ans;
                        }

                        // Add next transformation
                        q.offer(t);

                        // Remove to prevent revisiting
                        words.remove(t);
                    }

                    // Restore original character
                    chars[j] = ch;
                }
            }
        }

        // No transformation possible
        return 0;
    }
}
