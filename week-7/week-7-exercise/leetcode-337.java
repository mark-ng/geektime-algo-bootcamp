/**
 * 題目：打家劫舍 III (Medium)
 */

class Solution {
    public int rob(TreeNode root) {
       // f[x][0] = sum(max(f[y][0], f[y][1])) where y is a son of x
       // f[x][1] = val(x) + sum(f[y][0]) where y is a son of x
       // target: max(f[root, 0], f[root, 1])
        f = new HashMap<TreeNode, int[]>();
        f.put(null, new int[]{0, 0});
        dfs(root);
        return Math.max(f.get(root)[0], f.get(root)[1]);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        f.put(root, new int[2]);
        
        dfs(root.left);
        dfs(root.right);

        f.get(root)[0] = 
            Math.max(f.get(root.left)[0], f.get(root.left)[1]) +
            Math.max(f.get(root.right)[0], f.get(root.right)[1]);
        f.get(root)[1] = f.get(root.left)[0] + f.get(root.right)[0] + root.val;
    }

    HashMap<TreeNode, int[]> f;
}