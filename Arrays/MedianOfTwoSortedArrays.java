class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            // Partition position in nums1
            int partitionX = (left + right) / 2;

            // Partition position in nums2
            int partitionY = (m + n + 1) / 2 - partitionX;

            // Left and right boundary values for nums1
            int maxLeftX =
                (partitionX == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionX - 1];

            int minRightX =
                (partitionX == m)
                    ? Integer.MAX_VALUE
                    : nums1[partitionX];

            // Left and right boundary values for nums2
            int maxLeftY =
                (partitionY == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionY - 1];

            int minRightY =
                (partitionY == n)
                    ? Integer.MAX_VALUE
                    : nums2[partitionY];

            // Correct partition found
            if (maxLeftX <= minRightY &&
                maxLeftY <= minRightX) {

                // Even total length
                if ((m + n) % 2 == 0) {

                    return (
                        (double) Math.max(maxLeftX, maxLeftY)
                        + Math.min(minRightX, minRightY)
                    ) / 2.0;

                }

                // Odd total length
                return (double) Math.max(maxLeftX, maxLeftY);

            }

            // Move search to the left
            else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            }

            // Move search to the right
            else {
                left = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
