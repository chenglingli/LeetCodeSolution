
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricForTwoTree(root, root);
    }

    public boolean isSymmetricForTwoTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) return p == null && q == null;
        if (p.val != q.val) return false;
        if (p.right == null
                && p.left == null
                && q.right == null
                && q.left == null)
            return true;
        return isSymmetricForTwoTree(p.right, q.left) && isSymmetricForTwoTree(p.left, q.right);
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();

        TreeNode t1 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        t1.right = p2;

        boolean res = s.isSymmetric(t1);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}