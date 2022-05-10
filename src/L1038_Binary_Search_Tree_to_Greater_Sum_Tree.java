public class L1038_Binary_Search_Tree_to_Greater_Sum_Tree {

    /**
     * Given the root of a binary search tree with distinct values,
     * modify it so that every node has a new value equal to the sum
     * of the values of the original tree that are greater than or equal to node.val.
     * <p>
     * As a reminder, a binary search tree is a tree that satisfies these constraints:
     * <p>
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     * <p>
     * <p>
     * Note:
     * <p>
     * The number of nodes in the tree is between 1 and 100.
     * Each node will have value between 0 and 100.
     * The given tree is a binary search tree.
     */

    public int postVisit2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.right != null) {
            postVisit2(root.right);
        }

        System.out.println(root.val);

        if (root.left != null) {
            postVisit2(root.left);
        }

        return root.val;
    }

    public int postVisit(TreeNode root, int addVal) {

        if (root == null) {
            return 0;
        }

        int resVal = 0;

        int rightVal = 0;

        if (root.right != null) {
            rightVal = postVisit(root.right, addVal);
        }

        resVal = resVal + rightVal;
        resVal = resVal + root.val;

        root.val = root.val + rightVal + addVal;
        // System.out.println(root.val);

        int leftVal = 0;
        if (root.left != null) {
            leftVal = postVisit(root.left, root.val);
        }

        resVal = resVal + leftVal;

        return resVal;
    }

    public TreeNode bstToGst(TreeNode root) {
        postVisit(root, 0);
        return root;
    }

    public static void main(String[] args) {

        L1038_Binary_Search_Tree_to_Greater_Sum_Tree s = new L1038_Binary_Search_Tree_to_Greater_Sum_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);

        root4.left = root1;
        root4.right = root6;

        root1.left = root;
        root1.right = root2;

        root2.right = root3;

        root6.left = root5;
        root6.right = root7;

        root7.right = root8;

        s.postVisit2(root4);
        System.out.println();
        s.bstToGst(root4);

//        TreeNode res = s.bstToGst(root);
//        System.out.println(res.val);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}