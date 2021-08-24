public class L110_Balanced_Binary_Tree {


    // [1,2,2,3,null,null,3,4,null,null,4]
    //
    public boolean isBalanced2(TreeNode root) {
        return level(root) != -1;
    }

    public int level(TreeNode root) {
        if (root == null)
            return 0;

        int left = level(root.left);
        int right = level(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }



    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int rightHeight = 0, leftHeight = 0;
        if (root.right != null) {
            if (!isBalanced(root.right)) {
                return false;
            }
            rightHeight = maxDepth(root.right);
        }
        if (root.left != null) {
            if (!isBalanced(root.left)) {
                return false;
            }
            leftHeight = maxDepth(root.left);
        }

        return Math.abs(rightHeight - leftHeight) <= 1;
    }

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

    public static void main(String[] args) {
        L110_Balanced_Binary_Tree s = new L110_Balanced_Binary_Tree();
        long sysDate1 = System.currentTimeMillis();

        // [2,null,3,null,4,null,5,null,6]

        // init data
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root2.right = root4;

        root3.left = root5;
        root4.right = root6;

        System.out.println(s.isBalanced2(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}