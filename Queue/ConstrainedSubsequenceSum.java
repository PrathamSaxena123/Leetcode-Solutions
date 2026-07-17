import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int constrainedSubsetSum(int[] nums, int k) {

        int n = nums.length;

        // dp[i] = Maximum constrained subsequence sum ending at index i
        int[] dp = new int[n];

        // Stores the overall maximum subsequence sum
        int maxSum = nums[0];

        // Monotonic deque storing indices with decreasing dp values
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Start a new subsequence from the current element
            dp[i] = nums[i];

            // Remove indices that are outside the window of size k
            if (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.pollFirst();
            }

            // Extend the best previous subsequence if beneficial
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], dp[i] + dp[deque.peekFirst()]);
            }

            // Update the global maximum
            maxSum = Math.max(maxSum, dp[i]);

            // Maintain deque in decreasing order of dp values
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            // Store current index
            deque.offerLast(i);
        }

        return maxSum;
    }
}
