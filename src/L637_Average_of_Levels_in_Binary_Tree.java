import struct.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L637_Average_of_Levels_in_Binary_Tree {


    /*

    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
    Answers within 10^-5 of the actual answer will be accepted.


    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: [3.00000,14.50000,11.00000]
    Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
    Hence return [3, 14.5, 11].


    Example 2:

    Input: root = [3,9,20,15,7]
    Output: [3.00000,14.50000,11.00000]


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -2^31 <= Node.val <= 2^31 - 1

     */
    public List<Double> averageOfLevels(TreeNode root) {
        // 层序遍历，每一层遍历完，计算总和和个数，总和除以个数即为平均值

        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum / size);
        }

        return res;
    }

    public static void main(String[] args) {

        L637_Average_of_Levels_in_Binary_Tree s = new L637_Average_of_Levels_in_Binary_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> res = s.averageOfLevels(root);
        System.out.println(res.toString());

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}