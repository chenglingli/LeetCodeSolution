import struct.TreeNode;

import java.util.*;

public class L107_Binary_Tree_Level_Order_Traversal_II {

    /*
    Given the root of a binary tree,
    return the bottom-up level order traversal of its nodes' values.
    (i.e., from left to right, level by level from leaf to root).



    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: [[15,7],[9,20],[3]]
    Example 2:

    Input: root = [1]
    Output: [[1]]
    Example 3:

    Input: root = []
    Output: []


    Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 思路，先用层序遍历，然后反转结果

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }

        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        L107_Binary_Tree_Level_Order_Traversal_II s = new L107_Binary_Tree_Level_Order_Traversal_II();
        long sysDate1 = System.currentTimeMillis();

        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);

        List<List<Integer>> t = s.levelOrderBottom(r);

        System.out.println(t.toString());

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}