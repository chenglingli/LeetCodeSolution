import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L1302_Deepest_Leaves_Sum {

    /*
    Given the root of a binary tree, return the sum of values of its deepest leaves.


    Example 1:
    Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
    Output: 15

    Example 2:
    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    Output: 19


    Constraints:
    The number of nodes in the tree is in the range [1, 10^4].
    1 <= Node.val <= 100
     */

    // 层序遍历
    public int deepestLeavesSum(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            List<TreeNode> levelNodes = new ArrayList<>(size);

            // 遍历当前层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return sum;
    }

    // 递归
    int sum = 0, maxDepth = 0;
    public void findSum(TreeNode root, int depth) {
        if (root == null)
            return;
        else if (depth == maxDepth)
            sum += root.val;
        else if (depth > maxDepth) {
            maxDepth = depth;
            sum = root.val;
        }
        findSum(root.left, depth + 1);
        findSum(root.right, depth + 1);
    }

    public int deepestLeavesSum2(TreeNode root) {
        findSum(root, 0);
        return sum;
    }

    public static void main(String[] args) {

        L1302_Deepest_Leaves_Sum s = new L1302_Deepest_Leaves_Sum();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        int res = s.deepestLeavesSum(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}