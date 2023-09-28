import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L144_Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                stack.pop();
                p = p.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        L144_Binary_Tree_Preorder_Traversal s = new L144_Binary_Tree_Preorder_Traversal();
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
        /**
         *    3
         *   20 9
         *      7 15
         *
         *
         *          1
         *        4   3
         *       2
         *
         *
         *
         */

        System.out.println(s.preorderTraversal(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}