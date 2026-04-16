import java.util.*;

class Solution {
    public int[] closestEqualElementQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q];
            List<Integer> positions = map.get(nums[index]);

            if (positions.size() == 1) {
                result[q] = -1;
                continue;
            }

            int pos = Collections.binarySearch(positions, index);

            int minDist = Integer.MAX_VALUE;

            if (pos > 0) {
                minDist = Math.min(minDist, index - positions.get(pos - 1));
            }

            if (pos < positions.size() - 1) {
                minDist = Math.min(minDist, positions.get(pos + 1) - index);
            }

            result[q] = minDist;
        }

        return result;
    }
}
