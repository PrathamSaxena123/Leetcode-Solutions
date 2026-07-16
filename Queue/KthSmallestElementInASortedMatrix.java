import java.util.PriorityQueue;

class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        // Min Heap stores {value, row, column}
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Insert the first element of each row
        // (Only up to k rows are needed)
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.add(new int[]{matrix[i][0], i, 0});
        }

        // Remove the smallest element k-1 times
        for (int i = 0; i < k - 1; i++) {

            int[] current = minHeap.poll();

            int row = current[1];
            int col = current[2];

            // Push the next element from the same row
            if (col + 1 < n) {
                minHeap.add(new int[]{
                        matrix[row][col + 1],
                        row,
                        col + 1
                });
            }
        }

        // The kth smallest element is now at the top
        return minHeap.poll()[0];
    }
}
