import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        if(root.left != null || root.right != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }

        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        L226_Invert_Binary_Tree s = new L226_Invert_Binary_Tree();
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

        System.out.println(s.invertTree(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}