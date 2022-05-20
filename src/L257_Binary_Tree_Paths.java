import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L257_Binary_Tree_Paths {

        List<String> res = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {

            if (root == null) {
                return res;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            dfs(root, sb);

            return res;
        }

        public void dfs(TreeNode cur, StringBuilder path) {

            // get the original length before adding new things into it,
            // will be used when we undo the step
            int originLength = path.length();

            if (cur.left == null && cur.right == null) {
                res.add(path.toString());
            }

            if (cur.left != null) {
                dfs(cur.left, path.append("->").append(cur.left.val));

                // undo the previous step
                path.setLength(originLength);
            }

            if (cur.right != null) {
                dfs(cur.right, path.append("->").append(cur.right.val));

                // undo the previous step
                path.setLength(originLength);
            }

        }


    public List<String> binaryTreePaths2(TreeNode root) {
        backtrack(root, new StringBuilder());
        return res;
    }

    private void backtrack(TreeNode cur, StringBuilder path) {
        if (cur == null) return;

        int originLength = path.length();  // get the original length before adding new things into it,
        // will be used when we undo the step

        path.append(cur.val);
        if (cur.left == null && cur.right == null) {
            res.add(path.toString());
        }
        else {
            // if it is not a leaf node, we need to add arrow
            path.append("->");

            backtrack(cur.left, path);
            backtrack(cur.right, path);
        }

        path.setLength(originLength);  // backtrack, undo the previous step
    }


    public static void main(String[] args) {
        L257_Binary_Tree_Paths s = new L257_Binary_Tree_Paths();
        long sysDate1 = System.currentTimeMillis();

        // [2,null,3,null,4,null,5,null,6]

        // init data
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        root.right = root1;
        root.left = root2;
        root1.right = root3;
        root1.left = root4;

        /*

           3
        20  9
           7 15



         */

        System.out.println(s.binaryTreePaths2(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}