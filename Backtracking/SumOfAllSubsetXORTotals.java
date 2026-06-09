class Solution {

    public int subsetXORSum(int[] nums) {

        // Start backtracking from index 0
        // with current XOR = 0
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums,
                          int index,
                          int currentXOR) {

        // Base case:
        // One complete subset has been formed
        if (index == nums.length) {
            return currentXOR;
        }

        // Choice 1:
        // Include current element in subset
        int include =
            backtrack(
                nums,
                index + 1,
                currentXOR ^ nums[index]
            );

        // Choice 2:
        // Exclude current element from subset
        int exclude =
            backtrack(
                nums,
                index + 1,
                currentXOR
            );

        // Sum contributions from both choices
        return include + exclude;
    }
}
