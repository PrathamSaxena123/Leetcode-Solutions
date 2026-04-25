class MyQueue {

    Stack<Integer> input;   // for push operations
    Stack<Integer> output;  // for pop/peek operations

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // Push element to the back of queue
    public void push(int x) {
        input.push(x);
    }
    
    // Remove element from front of queue
    public int pop() {
        shiftStacks();
        return output.pop();
    }
    
    // Get front element
    public int peek() {
        shiftStacks();
        return output.peek();
    }
    
    // Check if queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    
    // Transfer elements only when needed (lazy transfer)
    private void shiftStacks() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}
