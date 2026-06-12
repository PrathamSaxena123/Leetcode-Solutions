class Solution {

    public List<List<Integer>> permute(int[] nums) {

        // Stores all possible permutations
        List<List<Integer>> result = new ArrayList<>();

        // Tracks whether an element has already been used
        boolean[] used = new boolean[nums.length];

        // Start backtracking
        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // If current permutation is complete, save it
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try placing every unused number
        for (int i = 0; i < nums.length; i++) {

            // Skip if already included
            if (used[i]) {
                continue;
            }

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, used, current, result);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
