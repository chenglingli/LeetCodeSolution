public class L108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return dfs(nums, 0, len);
    }

    TreeNode dfs(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        L108_Convert_Sorted_Array_to_Binary_Search_Tree s =
                new L108_Convert_Sorted_Array_to_Binary_Search_Tree();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4};
        System.out.println(s.sortedArrayToBST(nums));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}