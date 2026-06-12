class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        // Stores all valid paths from source to target
        List<List<Integer>> result = new ArrayList<>();

        // Current path being explored
        List<Integer> path = new ArrayList<>();

        // Start from node 0
        path.add(0);

        dfs(graph, 0, path, result);

        return result;
    }

    private void dfs(int[][] graph,
                     int node,
                     List<Integer> path,
                     List<List<Integer>> result) {

        // Reached target node
        if (node == graph.length - 1) {

            // Store a copy of current path
            result.add(new ArrayList<>(path));
            return;
        }

        // Explore all neighbors
        for (int neighbor : graph[node]) {

            // Choose
            path.add(neighbor);

            // Explore
            dfs(graph, neighbor, path, result);

            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}
