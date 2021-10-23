/**
 * 題目： 冗余连接 (Medium)
 */
class Solution {
    public int[] findRedundantConnection(int[][] input) {
        // 出现过的最大的点就是n
        n = 0;
        for (int[] edge : input) {
            int u = edge[0];
            int v = edge[1];
            n = Math.max(n, u);
            n = Math.max(n, v);
        }

        // 模板：出边数组初始化        
        // 初态：[[], [], ... []]
        edges = new ArrayList<>();
        // [false, false, ...]
        visit = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Integer>());
            visit[i] = false;
        }

        hasCycle = false;

        // 加边
        for (int[] edge : input) {
            int u = edge[0];
            int v = edge[1];
            // 无向图看作双向边的有向图
            addEdge(u, v);
            addEdge(v, u);

            for (int i = 0; i <= n; i++) visit[i] = false;
            // 每加一条边，看图中是否多了环c
            dfs(u, -1);
            if(hasCycle) return edge;
        }
        return null;
    }

    // 模板：无向图深度优先遍历找环
    // visit数组，避免重复访问
    // 有father不代表有環，直接跳過
    private void dfs(int x, int fa) {
        // 第一步：标记已访问
        visit[x] = true;
        // 第二步：遍历所有出边
        for(Integer neighbour : edges.get(x)) {
            if(fa == neighbour) continue;
            if(visit[neighbour]) hasCycle = true;
            else dfs(neighbour, x);
        }
    }

    private void addEdge(int x, int y) {
        edges.get(x).add(y);
    }

    int n;
    // 出边数组
    private List<List<Integer>> edges;
    boolean hasCycle;
    private boolean[] visit;
}