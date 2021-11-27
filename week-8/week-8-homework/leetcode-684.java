/**
 * 題目： 冗余连接 (Medium)
 */

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) fa[i] = i;

        for (int i = 0; i < n; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (find(node1) == find(node2)) {
                return edges[i];
            } else {
                unionSet(node1, node2);
            }
        }

        return null;
    }

    public void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }

    public int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }

    int[] fa;
}