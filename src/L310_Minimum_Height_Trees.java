import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class L310_Minimum_Height_Trees {

    /*
    A tree is an undirected graph in which any two vertices are connected by exactly one path.
    In other words, any connected graph without simple cycles is a tree.

    Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates
    that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root.

    When you select a node x as the root, the result tree has height h. Among all possible rooted trees,
    those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

    Return a list of all MHTs' root labels. You can return the answer in any order.

    The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.



    Example 1:


    Input: n = 4, edges = [[1,0],[1,2],[1,3]]
    Output: [1]
    Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
    Example 2:


    Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
    Output: [3,4]


    Constraints:

    1 <= n <= 2 * 10^4
    edges.length == n - 1
    0 <= ai, bi < n
    ai != bi
    All the pairs (ai, bi) are distinct.
    The given input is guaranteed to be a tree and there will be no repeated edges.

    给的是无向树，任选一个点当根，树的高度是「根到最远叶子的边数」。要找出所有使高度最小的根（答案里最多 1 或 2 个点）。

    核心结论（不用枚举每个根）
    使高度最小的根，一定是这棵树的重心（centroid）：
    把树看成一层层「剥叶子」，不断删掉当前所有度为 1 的点，最后剩下 1 个或 2 个点，它们就是所有 MHT 的根。

    直观理解：若根选在一条长链的端点（叶子），最远点几乎在链的另一头，高度很大；根往中间挪，两头都变短，高度会下降；剥到不能再剥时，剩下的就是「几何中心」附近，对应最小高度。

    算法：逐层删叶子（拓扑式剥皮）
    建邻接表，统计每个点的度。
    把所有度为 1 的点放进队列（第一层叶子）。
    反复：弹出当前层所有叶子，删掉它们（从邻接里去掉边、邻居度减 1）；若邻居度变成 1，进下一层队列。
    当剩余点数 ≤ 2 时停止，剩下的点就是答案（n=1 时特判只有点 0）。


     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        // 特判：只有 1 个点，直接返回 [0]
        if (n == 1) {
            List<Integer> only = new ArrayList<>();
            only.add(0);
            return only;
        }

        // 建邻接表
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        // 统计每个点的度：deg[i] 表示点 i 的度(多少个连接的边)
        int[] deg = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
            deg[u]++;
            deg[v]++;
        }

        // 把所有度为 1 的点放进队列（第一层叶子）
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                que.addLast(i);
            }
        }

        // 反复：弹出当前层所有叶子，删掉它们（从邻接里去掉边、邻居度减 1）；若邻居度变成 1，进下一层队列。
        int left = n;
        while (left > 2) {
            int layer = que.size();
            left -= layer;
            for (int i = 0; i < layer; i++) {
                int leaf = que.pollFirst();
                for (int nei : g.get(leaf)) {
                    // 删掉叶子所在的边，邻居度减 1
                    deg[nei]--;
                    if (deg[nei] == 1) {
                        que.addLast(nei);
                    }
                }
            }
        }

        // 当剩余点数 ≤ 2 时停止，剩下的点就是答案（n=1 时特判只有点 0）。
        return new ArrayList<>(que);
    }


    public static void main(String[] args) {


        L310_Minimum_Height_Trees s = new L310_Minimum_Height_Trees();
        long sysDate1 = System.currentTimeMillis();

        int n = 8;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}, {5, 6}, {5, 7}};

        List<Integer> res = s.findMinHeightTrees(n, edges);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}