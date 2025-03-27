import struct.TreeNode;

public class L653_Two_Sum_IV_Input_is_a_BST {

    /**

     Given the root of a binary search tree and an integer k,
     return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.



     Example 1:
     Input: root = [5,3,6,2,4,null,7], k = 9
     Output: true


     Example 2:
     Input: root = [5,3,6,2,4,null,7], k = 28
     Output: false


     Constraints:

     The number of nodes in the tree is in the range [1, 104].
     -10^4 <= Node.val <= 10^4
     root is guaranteed to be a valid binary search tree.
     -10^5 <= k <= 10^5

     */

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null) return false;

        if (cur.val * 2 != k) {
            if (findTargetValue(root, k - cur.val))
                return true;
        }
        return dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    private boolean findTargetValue(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;

        if (root.val > target) {
            if (root.left != null) {
                return findTargetValue(root.left, target);
            }
        }
        else {
            if (root.right != null) {
                return findTargetValue(root.right,  target);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L653_Two_Sum_IV_Input_is_a_BST s = new L653_Two_Sum_IV_Input_is_a_BST();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 28;

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//
//        int k = 4;

        boolean res = s.findTarget(root, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}