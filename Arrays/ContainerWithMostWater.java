class Solution {

    public int maxArea(int[] height) {

        // Initialize two pointers
        int left = 0;
        int right = height.length - 1;

        // Stores the maximum water found so far
        int maxWater = 0;

        // Continue until the pointers meet
        while (left < right) {

            // Width between the two lines
            int width = right - left;

            // Water level is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);

            // Compute current container area
            int currentWater = width * currentHeight;

            // Update the maximum area
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer with the smaller height
            // in hopes of finding a taller boundary
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
