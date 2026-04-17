/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Create a dummy node to handle edge cases (like deleting head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers
        // Both start from dummy to maintain a gap
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 3: Move 'fast' pointer n+1 steps ahead
        // This creates a gap of n nodes between fast and slow
        for(int i = 0; i <= n; i++){
            if(fast == null) break; // safety check to avoid null pointer
            fast = fast.next;
        }

        // Step 4: Move both pointers together
        // When 'fast' reaches the end, 'slow' will be just before the node to delete
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        // Step 5: Delete the target node
        // Skip the nth node from end
        slow.next = slow.next.next;

        // Step 6: Return the updated list (skip dummy node)
        return dummy.next;
    }
}
