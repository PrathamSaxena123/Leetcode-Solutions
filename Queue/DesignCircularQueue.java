class MyCircularQueue {

    // Array used to store queue elements
    private final int[] data;

    // Points to the front element
    private int head;

    // Points to the rear element
    private int tail;

    // Current number of elements in the queue
    private int count;

    // Maximum capacity of the queue
    private final int capacity;

    public MyCircularQueue(int k) {

        data = new int[k];

        head = 0;

        // No rear element initially
        tail = -1;

        count = 0;

        capacity = k;
    }

    // Insert an element at the rear
    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        // Move tail circularly
        tail = (tail + 1) % capacity;

        data[tail] = value;

        count++;

        return true;
    }

    // Remove the front element
    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        // Move head circularly
        head = (head + 1) % capacity;

        count--;

        return true;
    }

    // Return the front element
    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return data[head];
    }

    // Return the rear element
    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return data[tail];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == capacity;
    }
}
