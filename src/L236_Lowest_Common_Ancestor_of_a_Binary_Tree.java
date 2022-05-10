public class L236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * <p>
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is
     * defined between two nodes p and q as the lowest node in T that has both p and q
     * as descendants (where we allow a node to be a descendant of itself).”
     * <p>
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be
     * a descendant of itself according to the LCA definition.
     * <p>
     * <p>
     * Note:
     * <p>
     * All of the nodes' values will be unique.
     * p and q are different and both values will exist in the binary tree.
     */


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {

        L236_Lowest_Common_Ancestor_of_a_Binary_Tree s = new L236_Lowest_Common_Ancestor_of_a_Binary_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;

        n2.right = n5;
        n2.left = n4;

        n3.right = n7;
        n3.left = n6;

        n5.right = n9;
        n5.left = n8;

        TreeNode res = s.lowestCommonAncestor(n1, n2, n9);
        System.out.println(res.val);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}