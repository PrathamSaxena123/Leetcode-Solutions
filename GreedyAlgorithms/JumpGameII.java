public class Solution {

    public int jump(int[] nums) {

        // If array has 0 or 1 element,
        // we're already at the destination
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        // Number of jumps taken
        int jumps = 0;

        // End of the current jump range
        int currentEnd = 0;

        // Furthest position reachable from current range
        int farthest = 0;

        // No need to process last index
        for (int i = 0; i < nums.length - 1; i++) {

            // Update furthest reachable index
            farthest = Math.max(
                farthest,
                i + nums[i]
            );

            // Reached the end of current jump range
            if (i == currentEnd) {

                // Must make another jump
                jumps++;

                // Extend range to the furthest reachable point
                currentEnd = farthest;

                // Already able to reach destination
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
