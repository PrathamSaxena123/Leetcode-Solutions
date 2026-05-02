class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {

        // Both null → symmetric
        if (t1 == null && t2 == null) return true;

        // One null → not symmetric
        if (t1 == null || t2 == null) return false;

        // Values must match AND cross-compare children
        return (t1.val == t2.val) &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }
}
