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
    public ListNode reverseList(ListNode head) {

        // Step 1: Initialize pointers
        ListNode prev = null;     // will become new head
        ListNode curr = head;     // start from original head

        // Step 2: Traverse the list
        while (curr != null) {

            // Store next node before breaking the link
            ListNode next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev and curr one step forward
            prev = curr;
            curr = next;
        }

        // Step 3: prev will be the new head of reversed list
        return prev;
    }
}
