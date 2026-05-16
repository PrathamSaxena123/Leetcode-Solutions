class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency matrix representation of graph
        int[][] g = new int[n][n];

        // Distance array
        int[] dist = new int[n];

        // Large value representing infinity
        final int inf = 1 << 29;

        // Initially all distances are infinity
        Arrays.fill(dist, inf);

        // Fill graph with infinity
        // meaning no direct edge initially
        for (var e : g) {
            Arrays.fill(e, inf);
        }

        // Build graph
        // Convert 1-based indexing to 0-based
        for (var e : times) {

            int u = e[0] - 1;
            int v = e[1] - 1;
            int w = e[2];

            g[u][v] = w;
        }

        // Starting node distance = 0
        dist[k - 1] = 0;

        // Visited array for Dijkstra
        boolean[] vis = new boolean[n];

        // Run Dijkstra n times
        for (int i = 0; i < n; ++i) {

            int t = -1;

            // Find unvisited node with minimum distance
            for (int j = 0; j < n; j++) {

                if (!vis[j] &&
                   (t == -1 || dist[t] > dist[j])) {

                    t = j;
                }
            }

            // Mark node as visited
            vis[t] = true;

            // Relax all neighboring edges
            for (int j = 0; j < n; ++j) {

                dist[j] = Math.min(
                    dist[j],
                    dist[t] + g[t][j]
                );
            }
        }

        // Find maximum distance
        int ans = 0;

        for (int x : dist) {
            ans = Math.max(ans, x);
        }

        // If some node unreachable -> return -1
        return ans == inf ? -1 : ans;
    }
}
