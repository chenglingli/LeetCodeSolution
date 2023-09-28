import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L111_Minimum_Depth_of_Binary_Tree {

    /**
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest
     * path from the root node down to the nearest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     */

    /*
    两种解决思路，一种是递归，一种是层序遍历。
    递归的方式
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftD = 0, rightD = 0;
        if (root.right != null && root.left != null) {
            rightD = 1 + minDepth(root.right);
            leftD = 1 + minDepth(root.left);
            return Math.min(leftD, rightD);
        } else if (root.left != null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + minDepth(root.right);
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

        L111_Minimum_Depth_of_Binary_Tree s = new L111_Minimum_Depth_of_Binary_Tree();
        long sysDate1 = System.currentTimeMillis();

        // [2,null,3,null,4,null,5,null,6]

        // init data
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);

        root.right = root1;
        root1.right = root2;
        root2.right = root3;
        root3.right = root4;

        System.out.println(s.minDepth2(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}