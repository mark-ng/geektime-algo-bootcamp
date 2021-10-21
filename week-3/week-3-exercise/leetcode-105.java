/**
 * 題目： 从前序与中序遍历序列构造二叉树 (Medium)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, preorder.length - 1);
    }

    // 用preorder[l1..r1] 和 inorder[l2..r2] 還原二叉樹
    TreeNode build(int l1, int r1, int l2, int r2) {
        if(l1 > r1) return null;
        TreeNode root = new TreeNode(preorder[l1]);
        // First, find where root is in inorder, so that I can determine how long is left tree represent in preorder
        int mid = l2;
        while(inorder[mid] != root.val) mid++;
        // For inorder:
        // left: l2...mid-1
        // right: mid+1...r2

        // For preorder:
        // left: l1 + 1...l1 + ((mid - 1) - l2 + 1)
        // right: l1 + ((mid - 1) - l2 + 1) + 1...r1
        root.left = build(l1 + 1, l1 + ((mid - 1) - l2 + 1), l2, mid - 1);
        root.right = build(l1 + ((mid - 1) - l2 + 1) + 1, r1, mid + 1, r2);
        return root;
    }

    int[] preorder;
    int[] inorder;
}