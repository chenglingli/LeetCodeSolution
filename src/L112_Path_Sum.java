public class L112_Path_Sum {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        if (root.right == null && root.left == null) {
            return sum == root.val;
        }

        if (root.right != null) {
            boolean resR = hasPathSum(root.right, sum - root.val);
            if (resR) return true;
        }

        if (root.left != null) {
            boolean resL = hasPathSum(root.left, sum - root.val);
            if (resL) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L112_Path_Sum s = new L112_Path_Sum();

        long sysDate1 = System.currentTimeMillis();

        int sum = 22;

        TreeNode t = new TreeNode(1);

        boolean res = s.hasPathSum(t, sum);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}