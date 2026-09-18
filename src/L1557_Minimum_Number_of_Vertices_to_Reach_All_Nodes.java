import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes {


    /*

    Given a directed acyclic graph, with n vertices numbered from 0 to n-1,
    and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.

    Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.

    Notice that you can return the vertices in any order.

    Example 1:
    Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]

    Output: [0,3]
    Explanation: It's not possible to reach all the nodes from a single vertex. From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output [0,3].

    Example 2:
    Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
    Output: [0,2,3]
    Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other node, so we must include them. Also any of these vertices can reach nodes 1 and 4.


    Constraints:
    2 <= n <= 10^5
    1 <= edges.length <= min(10^5, n * (n - 1) / 2)
    edges[i].length == 2
    0 <= fromi, toi < n
    All pairs (fromi, toi) are distinct.

     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        // 思路：寻找入度为0的节点
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }

    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean[] incoming = new boolean[n];
        for (List<Integer> edge : edges) {
            incoming[edge.get(1)] = true;
        }

        for(int i = 0 ; i < n ; i++){
            if(!incoming[i]){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        L1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes s =
                new L1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes();
        long sysDate1 = System.currentTimeMillis();

        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<Integer>() {{
            add(0);
            add(1);
        }});
        edges.add(new ArrayList<Integer>() {{
            add(0);
            add(2);
        }});
        edges.add(new ArrayList<Integer>() {{
            add(2);
            add(5);
        }});
        edges.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});

        edges.add(new ArrayList<Integer>() {{
            add(4);
            add(2);
        }});

        List<Integer> res = s.findSmallestSetOfVertices(n, edges);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}