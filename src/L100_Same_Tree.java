/**
 * 检查两棵树是否长得一样
 * <p>
 * 采用递归的方式判断
 */

public class L100_Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) return p == null && q == null;
        if (p.val != q.val) return false;
        if (p.right == null
                && p.left == null
                && q.right == null
                && q.left == null)
            return true;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {

        L100_Same_Tree s = new L100_Same_Tree();

        long sysDate1 = System.currentTimeMillis();

        //        TreeNode t1 = new TreeNode(1);
        //        TreeNode p1 = new TreeNode(2);
        //        TreeNode p2 = new TreeNode(3);
        //        t1.right = p2;
        //
        //        TreeNode t2 = new TreeNode(1);
        //        TreeNode p3 = new TreeNode(2);
        //        TreeNode p4 = new TreeNode(3);
        //        t2.right = p4;


        TreeNode t1 = null;
        TreeNode t2 = null;
        boolean res = s.isSameTree(t1, t2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}