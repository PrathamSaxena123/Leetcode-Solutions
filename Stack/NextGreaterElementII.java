class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Initialize result with -1 (default if no greater element exists)
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>(); // stores indices

        // Traverse array twice to simulate circular behavior
        for (int i = 0; i < 2 * n; i++) {

            int num = nums[i % n];

            // Resolve elements whose next greater element is found
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int index = stack.pop();
                result[index] = num;
            }

            // Only push indices from first pass
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
