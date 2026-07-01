class Skiplist {

    // Maximum number of levels allowed in the Skip List
    private static final int MAX_LEVEL = 16;

    // Probability used to determine the height of a new node
    private static final double P = 0.5;

    // Node of the Skip List
    static class Node {
        int val;
        Node[] forward;

        public Node(int val, int level) {
            this.val = val;

            // Forward pointers for each level
            this.forward = new Node[level + 1];
        }
    }

    // Head node of the Skip List
    private final Node head;

    // Current highest level in the Skip List
    private int currentLevel;

    // Random generator for assigning levels
    private final Random random;

    public Skiplist() {

        head = new Node(-1, MAX_LEVEL);
        currentLevel = 0;
        random = new Random();
    }

    // Randomly generate a level for a new node
    private int randomLevel() {

        int lvl = 0;

        while (random.nextDouble() < P && lvl < MAX_LEVEL) {
            lvl++;
        }

        return lvl;
    }

    // Search for a target value
    public boolean search(int target) {

        Node current = head;

        // Start searching from the highest level
        for (int i = currentLevel; i >= 0; i--) {

            while (current.forward[i] != null &&
                   current.forward[i].val < target) {

                current = current.forward[i];
            }
        }

        // Move to the candidate node on level 0
        current = current.forward[0];

        return current != null && current.val == target;
    }

    // Insert a new value
    public void add(int num) {

        Node[] update = new Node[MAX_LEVEL + 1];
        Node current = head;

        // Find insertion positions at every level
        for (int i = currentLevel; i >= 0; i--) {

            while (current.forward[i] != null &&
                   current.forward[i].val < num) {

                current = current.forward[i];
            }

            update[i] = current;
        }

        // Determine the level of the new node
        int rLevel = randomLevel();

        // Increase Skip List height if necessary
        if (rLevel > currentLevel) {

            for (int i = currentLevel + 1; i <= rLevel; i++) {
                update[i] = head;
            }

            currentLevel = rLevel;
        }

        // Create and insert the new node
        Node newNode = new Node(num, rLevel);

        for (int i = 0; i <= rLevel; i++) {

            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    // Delete a value from the Skip List
    public boolean erase(int num) {

        Node[] update = new Node[MAX_LEVEL + 1];
        Node current = head;

        // Find predecessor nodes at every level
        for (int i = currentLevel; i >= 0; i--) {

            while (current.forward[i] != null &&
                   current.forward[i].val < num) {

                current = current.forward[i];
            }

            update[i] = current;
        }

        current = current.forward[0];

        // Value found
        if (current != null && current.val == num) {

            // Remove the node from every level
            for (int i = 0; i <= currentLevel; i++) {

                if (update[i].forward[i] != current) {
                    break;
                }

                update[i].forward[i] = current.forward[i];
            }

            // Remove empty top levels
            while (currentLevel > 0 &&
                   head.forward[currentLevel] == null) {

                currentLevel--;
            }

            return true;
        }

        return false;
    }
}
