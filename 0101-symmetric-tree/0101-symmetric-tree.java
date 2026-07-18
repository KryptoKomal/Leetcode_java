/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    // Helper method to cross-validate two subtrees in a mirror-image sequence 🪞
    public boolean helper(TreeNode p, TreeNode q) {
        // Case 1: Both nodes are null — perfectly balanced structural match ✓
        if (p == null && q == null) return true;
        
        // Case 2: One node is null while the other exists — structural asymmetry ✗
        if (p == null || q == null) return false;
        
        // Case 3: The values of the corresponding mirror nodes don't match ✗
        if (p.val != q.val) return false;
        
        // Recursively cross-check outer branches and inner branches simultaneously 🔀
        return helper(p.left, q.right) && helper(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // Launch mirror comparisons using the left and right children of the root anchor node
        return helper(root.left, root.right);
    }
}