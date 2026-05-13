class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list graph
        // g[i] stores all courses that depend on course i
        List<Integer>[] g = new List[numCourses];

        // Initialize each list in the graph
        Arrays.setAll(g, k -> new ArrayList<>());

        // indeg[i] = number of prerequisites required for course i
        int[] indeg = new int[numCourses];

        // Build graph + indegree array
        for (var p : prerequisites) {

            // a = course to take
            // b = prerequisite course
            int a = p[0], b = p[1];

            // Edge: b -> a
            // Means after completing b, we can take a
            g[b].add(a);

            // Increase indegree of course a
            ++indeg[a];
        }

        // Queue for courses having indegree = 0
        // (courses with no prerequisites)
        Deque<Integer> q = new ArrayDeque<>();

        // Add all courses with no prerequisites into queue
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        // Stores final topological order
        int[] ans = new int[numCourses];

        // Tracks how many courses are processed
        int cnt = 0;

        // Kahn's Algorithm (BFS Topological Sort)
        while (!q.isEmpty()) {

            // Remove course from queue
            int i = q.poll();

            // Add course to answer
            ans[cnt++] = i;

            // Visit all dependent courses
            for (int j : g[i]) {

                // Remove dependency
                --indeg[j];

                // If no prerequisites left, add to queue
                if (indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }

        // If all courses processed, return order
        // Otherwise cycle exists -> impossible to finish
        return cnt == numCourses ? ans : new int[0];
    }
}
