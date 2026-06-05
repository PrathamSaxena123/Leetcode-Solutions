import java.util.Arrays;

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        // Edge case: no intervals
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their ending time
        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[1], b[1]));

        // Number of intervals removed
        int removalCount = 0;

        // End time of the last interval we decided to keep
        int currentEnd = intervals[0][1];

        // Check remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Overlap detected
            if (intervals[i][0] < currentEnd) {

                // Remove current interval
                removalCount++;
            }
            else {

                // Keep current interval
                currentEnd = intervals[i][1];
            }
        }

        return removalCount;
    }
}
