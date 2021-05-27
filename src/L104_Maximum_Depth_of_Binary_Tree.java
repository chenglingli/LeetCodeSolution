import java.util.LinkedList;
import java.util.Queue;

public class L104_Maximum_Depth_of_Binary_Tree {

    /**
     Given the root of a binary tree, return its maximum depth.

     A binary tree's maximum depth is the number of nodes
     along the longest path from the root node down to the farthest leaf node.
     */

    /*
    两种解决思路，一种是递归，一种是层序遍历。
    递归的方式
     */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftD = 0, rightD = 0;
        if (root.right != null && root.left != null) {
            rightD =  1 + maxDepth(root.right);
            leftD = 1 + maxDepth(root.left);
            return Math.max(leftD, rightD);
        }
        else if (root.left != null) {
            return 1 + maxDepth(root.left);
        }
        else {
            return 1 + maxDepth(root.right);
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
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
        L104_Maximum_Depth_of_Binary_Tree s = new L104_Maximum_Depth_of_Binary_Tree();
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
        root.left = root2;
        root1.right = root3;
        root1.left = root4;

        System.out.println(s.maxDepth2(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}