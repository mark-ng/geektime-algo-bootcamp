/**
 * 題目： 验证二叉搜索树 (Medium)
 */
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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long leftMin, long rightMax) {
        if(root == null) return true;
        if(root.val < leftMin || root.val > rightMax) return false;
        return valid(root.left, leftMin, (long) root.val - 1) && valid(root.right, (long) root.val + 1, rightMax);
    }
}

x^3/2
x^1 = 2
ans = 2 * 2 = 4
4 * 2 = 8