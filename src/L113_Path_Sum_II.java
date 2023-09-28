import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L113_Path_Sum_II {

    void backtrack(TreeNode root, List<List<Integer>> res, List<Integer> tmp, int sum) {

        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null && sum == root.val) {
            List<Integer> resTmp = new ArrayList<>(tmp);
            resTmp.add(root.val);
            res.add(resTmp);
            return;
        }

        tmp.add(root.val);
        backtrack(root.left, res, tmp, sum - root.val);
        backtrack(root.right, res, tmp, sum - root.val);
        tmp.remove(tmp.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, res, new ArrayList<>(), targetSum);
        return res;
    }

    public static void main(String[] args) {

        L113_Path_Sum_II s = new L113_Path_Sum_II();

        long sysDate1 = System.currentTimeMillis();

        int sum = 22;

        // init data
        TreeNode root = new TreeNode(5);

        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(8);

        TreeNode root3 = new TreeNode(11);
        TreeNode root5 = new TreeNode(13);
        TreeNode root6 = new TreeNode(4);

        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(2);
        TreeNode root9 = new TreeNode(5);
        TreeNode root10 = new TreeNode(1);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root3.left = root7;
        root3.right = root8;

        root2.left = root5;
        root2.right = root6;

        root6.left = root9;
        root6.right = root10;


        // [-2,null,-3]

        TreeNode t = new TreeNode(-2);
        TreeNode t1 = new TreeNode(-3);
        t.left = t1;


        List<List<Integer>> res = s.pathSum(root, 22);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}