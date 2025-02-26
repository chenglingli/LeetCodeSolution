public class L1035_Uncrossed_Lines {

    /*
    You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2
        (in the order they are given) on two separate horizontal lines.

    We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

    nums1[i] == nums2[j], and
    the line we draw does not intersect any other connecting (non-horizontal) line.
    Note that a connecting line cannot intersect even at the endpoints
        (i.e., each number can only belong to one connecting line).

    Return the maximum number of connecting lines we can draw in this way.



    Example 1:

    Input: nums1 = [1,4,2], nums2 = [1,2,4]
    Output: 2
    Explanation: We can draw 2 uncrossed lines as in the diagram.
    We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4
        will intersect the line from nums1[2]=2 to nums2[1]=2.


    Example 2:

    Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
    Output: 3


    Example 3:

    Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
    Output: 2


    Constraints:

    1 <= nums1.length, nums2.length <= 500
    1 <= nums1[i], nums2[j] <= 2000

    方法1 DP
    dp[i][j] 表示 nums1 的前 i 个元素和 nums2 的前 j 个元素的最多不交叉连线数
    dp[i][j] = dp[i-1][j-1] + 1  if nums1[i - 1] == nums2[j - 1]
    dp[i][j] = max(dp[i-1][j], dp[i][j-1])  if nums1[i - 1] != nums2
    dp[0][j] = 0
    dp[i][0] = 0

    时间复杂度 O(m * n)

     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        if (m < n) {
            return maxUncrossedLines(nums2, nums1);
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        long sysDate1 = System.currentTimeMillis();
        L1035_Uncrossed_Lines s = new L1035_Uncrossed_Lines();

        int[] nums1 = {3, 1, 4, 2, 5};
        int[] nums2 = {2, 3, 0, 3, 4};
        int res = s.maxUncrossedLines(nums1, nums2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}