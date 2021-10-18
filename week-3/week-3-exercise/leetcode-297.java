/**
 * 題目： 二叉树的序列化与反序列化 (Hard)
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    String[] strList;
    int cur;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ans = new ArrayList<>();
        recur(root, ans);
        return String.join(",", ans);
    }

    private void recur(TreeNode root, List<String> ans) {
        if(root == null) {
            ans.add("null");
            return;
        }
        ans.add(Integer.toString(root.val));
        recur(root.left, ans);
        recur(root.right, ans);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        strList = data.split(",");
        cur = 0;
        return restore();
    }

    private TreeNode restore() {
        if(strList[cur].equals("null")) {
            cur++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strList[cur]));
        cur++;
        node.left = restore();
        node.right = restore();
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));