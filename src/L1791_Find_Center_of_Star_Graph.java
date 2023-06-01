public class L1791_Find_Center_of_Star_Graph {

    /*
    3 <= n <= 10^5
    edges.length == n - 1
    edges[i].length == 2
    1 <= ui, vi <= n
    ui != vi
    The given edges represent a valid star graph.
     */
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0]) {
            return edges[0][0];
        } else if (edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        else {
            return edges[0][1];
        }
    }

    public static void main(String[] args) {

        L1791_Find_Center_of_Star_Graph s = new L1791_Find_Center_of_Star_Graph();
        long sysDate1 = System.currentTimeMillis();

        int[][] edges = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        int res = s.findCenter(edges);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}