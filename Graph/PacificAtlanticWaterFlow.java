class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // Grid dimensions
        int m = heights.length, n = heights[0].length;

        // vis1 -> cells reachable from Pacific Ocean
        // vis2 -> cells reachable from Atlantic Ocean
        boolean[][] vis1 = new boolean[m][n];
        boolean[][] vis2 = new boolean[m][n];

        // BFS queues for both oceans
        Deque<int[]> q1 = new ArrayDeque<>();
        Deque<int[]> q2 = new ArrayDeque<>();

        // Direction array for:
        // up, right, down, left
        int[] dirs = {-1, 0, 1, 0, -1};

        // Add Pacific & Atlantic border cells row-wise
        for (int i = 0; i < m; i++) {

            // Pacific -> left column
            q1.offer(new int[]{i, 0});
            vis1[i][0] = true;

            // Atlantic -> right column
            q2.offer(new int[]{i, n - 1});
            vis2[i][n - 1] = true;
        }

        // Add Pacific & Atlantic border cells column-wise
        for (int j = 0; j < n; j++) {

            // Pacific -> top row
            q1.offer(new int[]{0, j});
            vis1[0][j] = true;

            // Atlantic -> bottom row
            q2.offer(new int[]{m - 1, j});
            vis2[m - 1][j] = true;
        }

        // Generic BFS function
        // Traverses cells reachable from a given ocean
        BiConsumer<Deque<int[]>, boolean[][]> bfs = (q, vis) -> {

            while (!q.isEmpty()) {

                // Current cell
                var cell = q.poll();

                int x = cell[0];
                int y = cell[1];

                // Explore all 4 directions
                for (int k = 0; k < 4; k++) {

                    int nx = x + dirs[k];
                    int ny = y + dirs[k + 1];

                    // Valid cell conditions:
                    // 1. Inside grid
                    // 2. Not visited
                    // 3. Next height >= current height
                    //    (reverse water flow logic)
                    if (nx >= 0 && nx < m &&
                        ny >= 0 && ny < n &&
                        !vis[nx][ny] &&
                        heights[nx][ny] >= heights[x][y]) {

                        vis[nx][ny] = true;

                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        };

        // BFS from Pacific Ocean
        bfs.accept(q1, vis1);

        // BFS from Atlantic Ocean
        bfs.accept(q2, vis2);

        // Final answer list
        List<List<Integer>> ans = new ArrayList<>();

        // Cells reachable from BOTH oceans
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (vis1[i][j] && vis2[i][j]) {

                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }
}
