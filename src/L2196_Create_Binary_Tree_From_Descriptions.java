import struct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L2196_Create_Binary_Tree_From_Descriptions {

    /*

    You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti]
    indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

    If isLefti == 1, then childi is the left child of parenti.
    If isLefti == 0, then childi is the right child of parenti.
    Construct the binary tree described by descriptions and return its root.

    The test cases will be generated such that the binary tree is valid.



    Example 1:
    Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
    Output: [50,20,80,15,17,19]
    Explanation: The root node is the node with value 50 since it has no parent.
    The resulting binary tree is shown in the diagram.
    Example 2:


    Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
    Output: [1,2,null,null,3,4]
    Explanation: The root node is the node with value 1 since it has no parent.
    The resulting binary tree is shown in the diagram.


    Constraints:

    1 <= descriptions.length <= 104
    descriptions[i].length == 3
    1 <= parenti, childi <= 105
    0 <= isLefti <= 1
    The binary tree described by descriptions is valid.

     */
    public TreeNode createBinaryTree(int[][] descriptions) {

        // map 用来存储节点
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        // 构建树
        for (int[] desc : descriptions) {
            TreeNode parent = map.getOrDefault(desc[0], new TreeNode(desc[0]));
            TreeNode child =  map.getOrDefault(desc[1], new TreeNode(desc[1]));

            set.add(desc[1]);

            if (desc[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            map.put(desc[0], parent);
            map.put(desc[1], child);
        }

        for (int[] desc : descriptions) {
            if (!set.contains(desc[0])) {
                return map.get(desc[0]);
            }
        }

        return null;
    }

    public TreeNode createBinaryTree2(int[][] descriptions) {

        TreeNode[] nodes = new TreeNode[100001];

        // 将每个叶子节点放到数组上
        for (int[] row: descriptions) {
            nodes[row[1]] = new TreeNode(row[1]);
        }

        TreeNode root = null;

        for (int[] row: descriptions) {

            // 如果数组上不存在这个节点，说明它是根节点
            if (nodes[row[0]] == null) {
                root = nodes[row[0]] = new TreeNode(row[0]);
            }

            if (row[2] == 1) {
                nodes[row[0]].left = nodes[row[1]];
            } else {
                nodes[row[0]].right = nodes[row[1]];
            }
        }
        return root;
    }

    public static void main(String[] args) {

        L2196_Create_Binary_Tree_From_Descriptions s = new L2196_Create_Binary_Tree_From_Descriptions();
        long sysDate1 = System.currentTimeMillis();

        int[][] descriptions = new int[][]{
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };
        TreeNode res = s.createBinaryTree(descriptions);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}