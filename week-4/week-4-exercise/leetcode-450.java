/**
 * 題目： 删除二叉搜索树中的节点 (Medium)
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 簡單Cases: 没有左子树 or 没有右子树
            if (root.left == null) return root.right; // 没有左子树，让right代替root的位置            
            if (root.right == null) return root.left; // 没有右子树

            // 最煩case: 
            TreeNode next = root.right; // 找后继：右子树一路向左
            while(next.left != null) next = next.left;
            root.right = deleteNode(root.right, next.val);
            root.val = next.val;
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}