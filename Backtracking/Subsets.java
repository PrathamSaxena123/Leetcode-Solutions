class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        // Stores all generated subsets
        List<List<Integer>> result = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Every current combination is a valid subset
        result.add(new ArrayList<>(current));

        // Try including each remaining element
        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
