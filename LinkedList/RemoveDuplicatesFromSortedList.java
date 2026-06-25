class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        // Start traversing from the head
        ListNode cur = head;

        // Continue while current node and next node exist
        while (cur != null && cur.next != null) {

            // If current and next node have the same value,
            // skip the duplicate node
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                // Otherwise, move to the next distinct node
                cur = cur.next;
            }
        }

        // Return the modified linked list
        return head;
    }
}
