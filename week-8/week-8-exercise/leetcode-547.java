/**
 * 題目： 省份数量 (Medium)
 */


class Solution {
    public int findCircleNum(int[][] isConnected) {

        fa = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) fa[i] = i;

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    unionSet(i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < fa.length; i++) {
            if (fa[i] == i) ans++;
        }

        return ans;
    }

    public int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }

    public void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }

    int[] fa;
}