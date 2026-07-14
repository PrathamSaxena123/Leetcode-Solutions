import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {

        // Stack to store operands
        Stack<Integer> stack = new Stack<>();

        // Traverse each token
        for (String token : tokens) {

            // If the token is an operator
            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                // Pop the top two operands
                int b = stack.pop();
                int a = stack.pop();

                // Perform the corresponding operation
                if (token.equals("+")) {
                    stack.push(a + b);

                } else if (token.equals("-")) {
                    stack.push(a - b);

                } else if (token.equals("*")) {
                    stack.push(a * b);

                } else if (token.equals("/")) {
                    stack.push(a / b);
                }

            } else {

                // Token is a number, push it onto the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // Final result remains at the top of the stack
        return stack.pop();
    }
}
