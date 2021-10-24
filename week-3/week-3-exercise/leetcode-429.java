/**
 * 題目： N 叉树的层序遍历 (Medium)
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    class Pair {
        Node node;
        int depth;

        Pair(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            Node val = q.peek().node;
            int depth = q.poll().depth;
            if(depth >= ans.size()) ans.add(new ArrayList<Integer>());
            ans.get(depth).add(val.val);
            for(Node n: val.children) {
                q.offer(new Pair(n, depth + 1));
            }
        }
        return ans;
    }
}