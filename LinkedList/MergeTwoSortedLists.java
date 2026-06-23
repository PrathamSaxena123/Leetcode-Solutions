/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node simplifies handling the head of the merged list
        ListNode dummy = new ListNode(-1);

        // Pointer used to build the merged list
        ListNode current = dummy;

        // Compare nodes from both lists until one becomes empty
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                // Attach the smaller node from list1
                current.next = list1;
                list1 = list1.next;

            } else {

                // Attach the smaller node from list2
                current.next = list2;
                list2 = list2.next;
            }

            // Move the merged list pointer forward
            current = current.next;
        }

        // Attach the remaining nodes (only one list can be non-empty)
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // The merged list starts after the dummy node
        return dummy.next;
    }
}
