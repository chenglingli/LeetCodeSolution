import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L2415_Reverse_Odd_Levels_of_Binary_Tree {

    /*
        Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.

    For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
    Return the root of the reversed tree.

    A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.

    The level of a node is the number of edges along the path between it and the root node.



    Example 1:


    Input: root = [2,3,5,8,13,21,34]
    Output: [2,5,3,8,13,21,34]
    Explanation:
    The tree has only one odd level.
    The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
    Example 2:


    Input: root = [7,13,11]
    Output: [7,11,13]
    Explanation:
    The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
    Example 3:

    Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
    Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
    Explanation:
    The odd levels have non-zero values.
    The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
    The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.


    Constraints:

    The number of nodes in the tree is in the range [1, 214].
    0 <= Node.val <= 10^5
    root is a perfect binary tree.
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return root;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>(size);

            // 遍历当前层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // 如果当前层是奇数层，则反转当前层
            if (level % 2 == 1) {
                for (int i = 0; i < size / 2; i++) {
                    TreeNode left = levelNodes.get(i);
                    TreeNode right = levelNodes.get(size - 1 - i);

                    // 交换当前层节点的值
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                }
            }

            level++;
        }

        return root;
    }

    public TreeNode reverseOddLevels2(TreeNode root) {
        if (root == null)
            return root;
        int level = 1;
        rev(root.left, root.right, level);
        return root;
    }

    public static void rev(TreeNode n1, TreeNode n2, int level) {
        if (n1 == null || n2 == null) return;
        if (level % 2 != 0) {
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }

        rev(n1.left, n2.right, level + 1);
        rev(n1.right, n2.left, level + 1);
    }

    public static void main(String[] args) {

        L2415_Reverse_Odd_Levels_of_Binary_Tree s = new L2415_Reverse_Odd_Levels_of_Binary_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        TreeNode res = s.reverseOddLevels(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}