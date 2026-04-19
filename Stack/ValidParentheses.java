class Solution {
    public boolean isValid(String s) {

        // Step 1: Create a stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Step 2: Traverse each character in the string
        for (char ch : s.toCharArray()) {

            // If it's an opening bracket → push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {
                // If stack is empty → no matching opening bracket
                if (stack.isEmpty()) return false;

                // Pop the top element (last unmatched opening bracket)
                char top = stack.pop();

                // Check if it matches the current closing bracket
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Step 3: If stack is empty → all brackets matched correctly
        return stack.isEmpty();
    }
}
