class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Phase 1: Drill left as deep as possible, pushing each node onto stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Phase 2: Backtrack — pop the deepest unprocessed left node
            curr = stack.pop();
            result.add(curr.val); // visit node (left -> root -> right order)

            // Phase 3: Explore right subtree next iteration
            curr = curr.right;
        }

        return result;
    }
}
