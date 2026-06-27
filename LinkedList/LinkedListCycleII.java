public class Solution {

    public ListNode detectCycle(ListNode head) {

        // A list with fewer than 2 nodes cannot contain a cycle
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect whether a cycle exists
        while (fast != null && fast.next != null) {

            // Slow moves one step
            slow = slow.next;

            // Fast moves two steps
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                // Phase 2:
                // Move one pointer to the head.
                // Move both pointers one step at a time.
                // They meet at the cycle's starting node.
                ListNode entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }

                return entry;
            }
        }

        // No cycle found
        return null;
    }
}
