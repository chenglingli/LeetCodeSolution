public class L938_Range_Sum_of_BST {

    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            sum += rangeSumBST(root.left, L, R);
        } else {
            sum += root.val;
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }

    public static void main(String[] args) {

        L938_Range_Sum_of_BST s = new L938_Range_Sum_of_BST();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(10);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(15);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(7);
        TreeNode root5 = new TreeNode(18);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.right = root5;

        int res = s.rangeSumBST(root, 7, 15);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}