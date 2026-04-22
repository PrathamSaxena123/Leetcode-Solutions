class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n]; // result array to store waiting days

        // Stack stores indices of days (not temperatures)
        Stack<Integer> stack = new Stack<>();

        // Traverse through each day
        for (int i = 0; i < n; i++) {

            // While current temperature is higher than the temperature
            // at index stored on top of stack → we found the next warmer day
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();

                // Calculate number of days waited
                ans[prevIndex] = i - prevIndex;
            }

            // Push current index onto stack
            stack.push(i);
        }

        // Remaining indices in stack have no warmer future day → default 0

        return ans;
    }
}
