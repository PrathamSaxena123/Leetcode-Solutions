class Solution {

    /**
     * Calculates an array where each element at index i is the product of all 
     * the numbers in the original array except the one at i.
     * * Time Complexity: O(n) - Two linear passes through the array.
     * Space Complexity: O(1) - Using the output array for calculations.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Prefix products
        // result[i] will store the product of all elements to the left of index i
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Suffix products
        // We use a running variable 'rightProduct' to represent the product 
        // of all elements to the right of the current index i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Multiply the existing prefix product by the current suffix product
            result[i] *= rightProduct;
            
            // Update the suffix product for the next element to the left
            rightProduct *= nums[i];
        }

        return result;
    }
}
