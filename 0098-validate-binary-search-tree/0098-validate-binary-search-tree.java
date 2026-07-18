/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean isValid = true;
    private TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }
    
    private void helper(TreeNode root)  {
        if (root == null) 
            return;
        helper(root.left);
        if (pre != null && pre.val >= root.val) {
            isValid = false;
            return;
        }
        pre = root;
        helper(root.right);
    }
} 