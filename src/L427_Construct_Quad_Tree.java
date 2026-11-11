import struct.Node427;

public class L427_Construct_Quad_Tree {


    /*
    Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.

    Return the root of the Quad-Tree representing grid.

    A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:

    val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
        Notice that you can assign the val to True or False when isLeaf is False, and both are accepted in the answer.

    isLeaf: True if the node is a leaf node on the tree or False if the node has four children.


    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
    }
    We can construct a Quad-Tree from a two-dimensional area using the following steps:

    If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.

    If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
    Recurse for each of the children with the proper sub-grid.

    If you want to know more about the Quad-Tree, you can refer to the wiki.

    Quad-Tree format:

    You don't need to read this section for solving the problem. This is only if you want to understand the output format here. The output represents the serialized format of a Quad-Tree using level order traversal, where null signifies a path terminator where no node exists below.

    It is very similar to the serialization of the binary tree. The only difference is that the node is represented as a list [isLeaf, val].

    If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val] and if the value of isLeaf or val is False we represent it as 0.



    Example 1:


    Input: grid = [[0,1],[1,0]]
    Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
    Explanation: The explanation of this example is shown below:
    Notice that 0 represents False and 1 represents True in the photo representing the Quad-Tree.

    Example 2:



    Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
    Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
    Explanation: All values in the grid are not the same. We divide the grid into four sub-grids.
    The topLeft, bottomLeft and bottomRight each has the same value.
    The topRight have different values so we divide it into 4 sub-grids where each has the same value.
    Explanation is shown in the photo below:



    Constraints:

    n == grid.length == grid[i].length
    n == 2^x where 0 <= x <= 6
     */
    public Node427 construct(int[][] grid) {
        /*

        题意：给定一个二维网格，用一个四叉树来表示。

        思路：
        1. 如果当前网格的值相同，则创建一个叶子节点，值为该值。
        2. 如果当前网格的值不同，则创建一个非叶子节点，并递归地构建四个子树。
        3. 返回构建好的四叉树。

         */
        return construct(grid, 0, 0, grid.length);
    }

    private Node427 construct(int[][] grid, int x, int y, int n) {
        if (isLeaf(grid, x, y, n)) {
            return new Node427(grid[x][y] == 1, true);
        } else {
            Node427 topLeft = construct(grid, x, y, n / 2);
            Node427 topRight = construct(grid, x, y + n / 2, n / 2);
            Node427 bottomLeft = construct(grid, x + n / 2, y, n / 2);
            Node427 bottomRight = construct(grid, x + n / 2, y + n / 2, n / 2);
            return new Node427(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    private boolean isLeaf(int[][] grid, int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != grid[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        L427_Construct_Quad_Tree s = new L427_Construct_Quad_Tree();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = new int[][]{
                {0, 1},
                {1, 0}
        };

        Node427 res = s.construct(grid);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}