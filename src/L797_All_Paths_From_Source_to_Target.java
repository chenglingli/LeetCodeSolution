import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L797_All_Paths_From_Source_to_Target {

    /*

    Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

    The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).



    Example 1:
    Input: graph = [[1,2],[3],[3],[]]
    Output: [[0,1,3],[0,2,3]]
    Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

    Example 2:
    Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
    Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]


    Constraints:
    n == graph.length
    2 <= n <= 15
    0 <= graph[i][j] < n
    graph[i][j] != i (i.e., there will be no self-loops).
    All the elements of graph[i] are unique.
    The input graph is guaranteed to be a DAG.

     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // DFS
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int[][] graph, int curNode, LinkedList<Integer> path, List<List<Integer>> res) {
        path.add(curNode);

        if (curNode == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int next : graph[curNode]) {
                dfs(graph, next, path, res);
            }
        }

        path.removeLast();
    }

    public static void main(String[] args) {

        L797_All_Paths_From_Source_to_Target s = new L797_All_Paths_From_Source_to_Target();
        long sysDate1 = System.currentTimeMillis();

        int[][] graph = new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        };
        List<List<Integer>> res = s.allPathsSourceTarget(graph);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}