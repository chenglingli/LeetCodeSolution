public class L1971_Find_if_Path_Exists_in_Graph {


    /*

    There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
    The edges in the graph are represented as a 2D integer array edges,
    where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.

    Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

    You want to determine if there is a valid path that exists from vertex source to vertex destination.

    Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.



    Example 1:


    Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
    Output: true
    Explanation: There are two paths from vertex 0 to vertex 2:
    - 0 → 1 → 2
    - 0 → 2


    Example 2:
    Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
    Output: false
    Explanation: There is no path from vertex 0 to vertex 5.


    Constraints:

    1 <= n <= 2 * 10^5
    0 <= edges.length <= 2 * 10^5
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui != vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self edges.

     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // DFS
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(int[][] graph, int source, int destination, boolean[] visited) {

        if (source == destination) {
            return true;
        }

        visited[source] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[source][i] == 1 && !visited[i]) {
                boolean res = dfs(graph, i, destination, visited);
                if (res) {
                    return true;
                }
            }
        }

        return false;
    }


    /*
    并查集

    逻辑：
    并查集的逻辑是，每个节点最开始指向自己。
    当我们遍历到某个节点时，我们把这个节点的父节点设置为另外一个节点。
    当我们需要查找某个节点的父节点时，我们一直往上找，直到找到指向自己的那个点。
    如果我们找到了两个节点的父节点相同，那么这两个点就是连通的。

    底层逻辑：
    构建多棵树（森林）
    并查集 = 森林
    text

    插入

    复制
    初始状态 (n个独立节点):
    0   1   2   3   4
    |   |   |   |   |
    0   1   2   3   4   ← 每个节点都是根，形成 n 棵树

    合并边 [0,1], [1,2] 后:
        0
        |
        1
        |
        2   3   4

    集合: {0,1,2} 和 {3,4} → 两棵树


    判断连通
    两节点在同一棵树（同一个根）→ 连通
    两节点在不同树（不同根）→ 不连通
    所以并查集的核心思想就是：用树结构维护集合关系，支持快速合并和查询。

    时间复杂度: O(α(n)) ≈ O(1)，其中 α 是反阿克曼函数，使用路径压缩和按秩合并优化
    空间复杂度: O(n)，用于存储 parent 数组


     */
    public boolean validPath2(int n, int[][] edges, int source, int destination) {

        int[] parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] e : edges) {
            union(parent, e[0], e[1]);
        }

        return find(parent, source) == find(parent, destination);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {

        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }

    public static void main(String[] args) {

        L1971_Find_if_Path_Exists_in_Graph s = new L1971_Find_if_Path_Exists_in_Graph();
        long sysDate1 = System.currentTimeMillis();

        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;

        boolean res = s.validPath(n, edges, source, destination);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}