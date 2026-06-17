class Solution {

    // Stores all shortest transformation sequences
    private List<List<String>> ans;

    // Maps each word to all of its predecessors in the shortest paths
    private Map<String, Set<String>> prev;

    public List<List<String>> findLadders(String beginWord,
                                          String endWord,
                                          List<String> wordList) {

        ans = new ArrayList<>();

        // Store all words in a set for O(1) lookup
        Set<String> words = new HashSet<>(wordList);

        // Impossible if endWord does not exist
        if (!words.contains(endWord)) {
            return ans;
        }

        // Prevent revisiting beginWord
        words.remove(beginWord);

        // Distance of each word from beginWord
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);

        prev = new HashMap<>();

        // Standard BFS queue
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        boolean found = false;
        int step = 0;

        // BFS to build shortest-path graph
        while (!q.isEmpty() && !found) {

            ++step;

            for (int i = q.size(); i > 0; --i) {

                String current = q.poll();
                char[] chars = current.toCharArray();

                // Change each character
                for (int j = 0; j < chars.length; ++j) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; ++c) {

                        chars[j] = c;
                        String next = new String(chars);

                        // Already reached at same level:
                        // just add another predecessor
                        if (dist.getOrDefault(next, 0) == step) {
                            prev.get(next).add(current);
                        }

                        // Skip invalid words
                        if (!words.contains(next)) {
                            continue;
                        }

                        // Record predecessor
                        prev.computeIfAbsent(
                            next,
                            key -> new HashSet<>()
                        ).add(current);

                        // Mark visited
                        words.remove(next);

                        q.offer(next);
                        dist.put(next, step);

                        if (endWord.equals(next)) {
                            found = true;
                        }
                    }

                    // Restore character
                    chars[j] = original;
                }
            }
        }

        // Reconstruct all shortest paths
        if (found) {

            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);

            dfs(path, beginWord, endWord);
        }

        return ans;
    }

    private void dfs(Deque<String> path,
                     String beginWord,
                     String current) {

        // Reached starting word
        if (current.equals(beginWord)) {

            ans.add(new ArrayList<>(path));
            return;
        }

        // Explore every predecessor
        for (String predecessor : prev.get(current)) {

            path.addFirst(predecessor);

            dfs(path, beginWord, predecessor);

            // Backtrack
            path.removeFirst();
        }
    }
}
