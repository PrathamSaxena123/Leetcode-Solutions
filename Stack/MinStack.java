class MinStack {

    Stack<Integer> stack;      // main stack to store values
    Stack<Integer> minStack;   // auxiliary stack to store minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    // Push element onto stack
    public void push(int val) {
        stack.push(val);

        // If minStack is empty OR current value is smaller/equal,
        // push it to minStack as new minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    // Remove top element
    public void pop() {
        int removed = stack.pop();

        // If removed element is current minimum, remove from minStack too
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }
    
    // Get top element
    public int top() {
        return stack.peek();
    }
    
    // Get minimum element in O(1)
    public int getMin() {
        return minStack.peek();
    }
}
