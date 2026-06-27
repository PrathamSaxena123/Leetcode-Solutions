public class LRUCache {

    // Node of the doubly linked list
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Maximum number of elements the cache can store
    private final int capacity;

    // HashMap for O(1) access to nodes
    private final Map<Integer, Node> map;

    // Dummy head and tail nodes of the doubly linked list
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();

        // Create dummy nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // Key not present
        if (!map.containsKey(key)) {
            return -1;
        }

        // Move the accessed node to the front
        Node node = map.get(key);
        remove(node);
        insertToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update its value
            node.value = value;

            // Move it to the front (most recently used)
            remove(node);
            insertToHead(node);

        } else {

            // Cache is full, remove the least recently used node
            if (map.size() == capacity) {

                Node lruNode = tail.prev;

                map.remove(lruNode.key);
                remove(lruNode);
            }

            // Create and insert the new node
            Node newNode = new Node(key, value);

            map.put(key, newNode);
            insertToHead(newNode);
        }
    }

    // Removes a node from the doubly linked list
    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Inserts a node immediately after the head
    // (Marks it as the most recently used)
    private void insertToHead(Node node) {

        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;
    }
}
