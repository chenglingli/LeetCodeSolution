import java.util.*;

public class L103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (level % 2 == 0) {
                Collections.reverse(tmp);
            }
            res.add(tmp);
            level++;
        }

        return res;
    }

    public static void main(String[] args) {
        L103_Binary_Tree_Zigzag_Level_Order_Traversal s = new L103_Binary_Tree_Zigzag_Level_Order_Traversal();
        long sysDate1 = System.currentTimeMillis();

        // [2,null,3,null,4,null,5,null,6]

        // init data
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);

        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root2.right = root4;

        System.out.println(s.zigzagLevelOrder(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}