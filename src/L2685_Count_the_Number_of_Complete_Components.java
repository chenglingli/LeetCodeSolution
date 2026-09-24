import java.util.*;

public class L2685_Count_the_Number_of_Complete_Components {

    /*

    You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1.
    You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

    Return the number of complete connected components of the graph.

    A connected component is a subgraph of a graph in which there exists a path between any two vertices,
    and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

    A connected component is said to be complete if there exists an edge between every pair of its vertices.



    Example 1:
    Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
    Output: 3
    Explanation: From the picture above, one can see that all of the components of this graph are complete.


    Example 2:
    Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
    Output: 1
    Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices.
    On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5.
    Thus, the number of complete components in this graph is 1.

    Constraints:
    1 <= n <= 50
    0 <= edges.length <= n * (n - 1) / 2
    edges[i].length == 2
    0 <= ai, bi <= n - 1
    ai != bi
    There are no repeated edges.

     */

    public int countCompleteComponents(int n, int[][] edges) {
        /*
        寻找图中有多少完全联通的子图

        完全联通子图意思是：
        图里面任意2个节点都相连

         */

        // 初始化并查集
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // 合并节点
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, size);
        }

        // 将变数都加到 父亲节点上
        int[] edgeCount = new int[n];
        for (int[] e : edges) {
            edgeCount[find(e[0], parent)]++;
        }

        // 统计完全联通的子图
        int ans = 0;
        for (int i = 0; i < n; i++) {

            // 跳过非父亲节点
            if (parent[i] != i) {
                continue;
            }

            // 统计父亲节点的大小和边数
            int v = size[i];
            int e = edgeCount[i];
            if (e == v * (v - 1) / 2) {
                ans++;
            }
        }

        // 返回完全联通的子图数量
        return ans;
    }

    // 寻找父亲节点
    public int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    // 合并节点
    public void union(int x, int y, int[] parent, int[] size) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) 
            return;

        // 父亲定义为size大的节点
        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    public static void main(String[] args) {

        L2685_Count_the_Number_of_Complete_Components s = new L2685_Count_the_Number_of_Complete_Components();
        long sysDate1 = System.currentTimeMillis();

        int n = 6;
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 2}, {3, 4}
        };

        int res = s.countCompleteComponents(n, edges);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}