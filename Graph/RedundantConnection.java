class Solution {

    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];

        // Initially every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // If already connected → redundant edge
            if (find(u) == find(v)) {
                return edge;
            }

            // Union
            parent[find(u)] = find(v);
        }

        return new int[]{};
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }

        return parent[x];
    }
}
