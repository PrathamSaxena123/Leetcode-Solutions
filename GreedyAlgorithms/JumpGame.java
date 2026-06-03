class Solution {

    public boolean canJump(int[] nums) {

        // Furthest index we can currently reach
        int maxReach = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If current index is beyond our reachable range,
            // we cannot proceed further
            if (i > maxReach) {
                return false;
            }

            // Update the furthest reachable position
            maxReach = Math.max(
                maxReach,
                i + nums[i]
            );
        }

        // Successfully reached every required position
        return true;
    }
}
