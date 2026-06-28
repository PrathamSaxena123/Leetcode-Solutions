class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // Min-Heap to always retrieve the smallest current node
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of every non-empty linked list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Dummy node to simplify merged list construction
        ListNode dummy = new ListNode();

        // Pointer used to build the merged list
        ListNode cur = dummy;

        // Continue until all nodes have been processed
        while (!pq.isEmpty()) {

            // Extract the smallest available node
            ListNode node = pq.poll();

            // If this node has a next node,
            // add it to the heap
            if (node.next != null) {
                pq.offer(node.next);
            }

            // Append the smallest node to the merged list
            cur.next = node;
            cur = cur.next;
        }

        // Return the merged linked list
        return dummy.next;
    }
}
