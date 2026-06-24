public class Solution {

    public boolean hasCycle(ListNode head) {

        // A list with 0 or 1 node cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {

            // Slow moves one step
            slow = slow.next;

            // Fast moves two steps
            fast = fast.next.next;

            // If they meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached the end, so no cycle exists
        return false;
    }
}
