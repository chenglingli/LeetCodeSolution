public class L3162_Find_the_Number_of_Good_Pairs_I {

    /*

    You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively. You are also given a positive integer k.

    A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).

    Return the total number of good pairs.



    Example 1:

    Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1

    Output: 5

    Explanation:

    The 5 good pairs are (0, 0), (1, 0), (1, 1), (2, 0), and (2, 2).
    Example 2:

    Input: nums1 = [1,2,4,12], nums2 = [2,4], k = 3

    Output: 2

    Explanation:

    The 2 good pairs are (3, 0) and (3, 1).



    Constraints:

    1 <= n, m <= 50
    1 <= nums1[i], nums2[j] <= 50
    1 <= k <= 50

     */
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (n1 % (k * n2) == 0)
                    ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L3162_Find_the_Number_of_Good_Pairs_I s = new L3162_Find_the_Number_of_Good_Pairs_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums1 = {1, 2, 4, 12};
        int[] nums2 = {2, 4};
        int k = 3;

        int res = s.numberOfPairs(nums1, nums2, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}