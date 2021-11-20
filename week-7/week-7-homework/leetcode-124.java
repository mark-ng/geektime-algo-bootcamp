/**
 * 題目：二叉树中的最大路径和 (Hard)
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        map = new HashMap<>();
        map.put(null, Integer.MIN_VALUE);
        dfs(root);
        int ans = Integer.MIN_VALUE;
        for (TreeNode key : map.keySet()) {
            ans = Math.max(ans, map.get(key));
        }
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null & root.right == null) {
            map.put(root, root.val);
            return root.val;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        int tempAns = root.val;
        if (leftHeight > 0) tempAns += leftHeight;
        if (rightHeight > 0) tempAns += rightHeight;
        map.put(root, tempAns);
        int longestPath = root.val;
        if (leftHeight > 0 & rightHeight > 0) {
            return Math.max(leftHeight, rightHeight) + root.val;
        } else if (leftHeight > 0) {
            return leftHeight + root.val;
        } else if (rightHeight > 0) {
            return rightHeight + root.val;
        } else {
            return root.val;
        }
    }

    HashMap<TreeNode, Integer> map;
}