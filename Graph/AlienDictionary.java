class Solution {

    public String findOrder(String[] words, int n, int k) {

        // g[i][j] means:
        // character i comes before character j
        boolean[][] g = new boolean[26][26];

        // Tracks which characters actually exist
        boolean[] s = new boolean[26];

        // Count of unique characters
        int cnt = 0;

        // -----------------------------
        // Phase 1: Collect unique chars
        // -----------------------------
        for (int i = 0; i < n - 1; ++i) {

            for (char c : words[i].toCharArray()) {

                if (cnt == 26) break;

                int idx = c - 'a';

                if (!s[idx]) {

                    ++cnt;
                    s[idx] = true;
                }
            }

            // -----------------------------------------
            // Phase 2: Build graph using adjacent words
            // -----------------------------------------
            int m = words[i].length();

            for (int j = 0; j < m; ++j) {

                // Invalid case:
                // "abc" before "ab"
                if (j >= words[i + 1].length()) {
                    return "";
                }

                char c1 = words[i].charAt(j);
                char c2 = words[i + 1].charAt(j);

                // Same character -> continue checking
                if (c1 == c2) {
                    continue;
                }

                // Reverse edge already exists
                // meaning cycle detected
                if (g[c2 - 'a'][c1 - 'a']) {
                    return "";
                }

                // Add directed edge
                c1 -> c2
                g[c1 - 'a'][c2 - 'a'] = true;

                // Only first different character matters
                break;
            }
        }

        // -----------------------------------
        // Add characters from last word too
        // -----------------------------------
        for (char c : words[n - 1].toCharArray()) {

            if (cnt == 26) break;

            int idx = c - 'a';

            if (!s[idx]) {

                ++cnt;
                s[idx] = true;
            }
        }

        // -----------------------------------
        // Phase 3: Compute indegrees
        // -----------------------------------
        int[] indegree = new int[26];

        for (int i = 0; i < 26; ++i) {

            for (int j = 0; j < 26; ++j) {

                if (i != j &&
                    s[i] &&
                    s[j] &&
                    g[i][j]) {

                    ++indegree[j];
                }
            }
        }

        // -----------------------------------
        // Phase 4: Kahn's Algorithm (BFS)
        // -----------------------------------
        Deque<Integer> q = new LinkedList<>();

        // Add nodes with indegree 0
        for (int i = 0; i < 26; ++i) {

            if (s[i] && indegree[i] == 0) {
                q.offerLast(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            int t = q.pollFirst();

            // Add character to answer
            ans.append((char) (t + 'a'));

            // Remove outgoing edges
            for (int i = 0; i < 26; ++i) {

                if (i != t &&
                    s[i] &&
                    g[t][i]) {

                    if (--indegree[i] == 0) {
                        q.offerLast(i);
                    }
                }
            }
        }

        // -----------------------------------
        // Phase 5: Cycle validation
        // -----------------------------------
        // If topo sort doesn't include
        // all characters -> cycle exists
        return ans.length() < cnt
               ? ""
               : ans.toString();
    }
}
