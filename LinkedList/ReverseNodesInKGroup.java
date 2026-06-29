class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        // No reversal needed for an empty list or k = 1
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node simplifies handling the head after reversals
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Count the total number of nodes
        ListNode countCheck = head;
        int count = 0;

        while (countCheck != null) {
            count++;
            countCheck = countCheck.next;
        }

        // Points to the tail of the previously reversed group
        ListNode prevGroupTail = dummy;

        // Current node from where the next group starts
        ListNode curr = head;

        // Reverse while at least k nodes remain
        while (count >= k) {

            // This will become the tail after reversal
            ListNode groupHead = curr;

            // Standard linked list reversal pointers
            ListNode prev = null;

            // Reverse exactly k nodes
            for (int i = 0; i < k; i++) {

                ListNode nextNode = curr.next;

                curr.next = prev;

                prev = curr;

                curr = nextNode;
            }

            // Connect previous group to the new head
            prevGroupTail.next = prev;

            // Connect the reversed group to the remaining list
            groupHead.next = curr;

            // Move to the tail of the newly reversed group
            prevGroupTail = groupHead;

            // Reduce remaining node count
            count -= k;
        }

        // Return the new head
        return dummy.next;
    }
}
