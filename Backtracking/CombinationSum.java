class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Stores all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        // Try every candidate starting from 'start'
        for (int i = start; i < candidates.length; i++) {

            // Choose current candidate
            current.add(candidates[i]);

            // Explore
            // Pass 'i' again because the same element
            // can be chosen multiple times
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
