import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    // Max Heap stores the smaller half of the numbers
    private PriorityQueue<Integer> smallMaxHeap;

    // Min Heap stores the larger half of the numbers
    private PriorityQueue<Integer> largeMinHeap;

    public MedianFinder() {

        // Max Heap (largest element on top)
        smallMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap (smallest element on top)
        largeMinHeap = new PriorityQueue<>();
    }

    // Add a new number into the data structure
    public void addNum(int num) {

        // Insert into the appropriate heap
        if (smallMaxHeap.isEmpty() || num <= smallMaxHeap.peek()) {
            smallMaxHeap.add(num);
        } else {
            largeMinHeap.add(num);
        }

        // Balance the heaps if the left heap becomes too large
        if (smallMaxHeap.size() > largeMinHeap.size() + 1) {
            largeMinHeap.add(smallMaxHeap.poll());

        // Balance if the right heap has more elements
        } else if (largeMinHeap.size() > smallMaxHeap.size()) {
            smallMaxHeap.add(largeMinHeap.poll());
        }
    }

    // Return the current median
    public double findMedian() {

        // Even number of elements
        if (smallMaxHeap.size() == largeMinHeap.size()) {
            return (smallMaxHeap.peek() + largeMinHeap.peek()) / 2.0;
        }

        // Odd number of elements
        return smallMaxHeap.peek();
    }
}
