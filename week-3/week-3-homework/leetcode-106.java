/**
 * 題目：从中序与后序遍历序列构造二叉树 (Medium)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, postorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int il, int ir, int pl, int pr) {
        if(pl > pr || il > ir) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int mid = il;
        while(inorder[mid] != root.val) mid++;
        root.left = build(il, mid - 1, pl, pl + mid - il - 1);
        root.right = build(mid + 1, ir, pl + mid - il, pr - 1);
        return root;
    }

    int[] inorder;
    int[] postorder;
}