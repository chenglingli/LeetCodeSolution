public class L3875_Construct_Uniform_Parity_Array_I {

    /*
    You are given an array nums1 of n distinct integers.

    You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.

    For each index i, you must choose exactly one of the following (in any order):

    nums2[i] = nums1[i]
    nums2[i] = nums1[i] - nums1[j], for an index j != i
    Return true if it is possible to construct such an array, otherwise, return false.



    Example 1:

    Input: nums1 = [2,3]

    Output: true

    Explanation:

    Choose nums2[0] = nums1[0] - nums1[1] = 2 - 3 = -1.
    Choose nums2[1] = nums1[1] = 3.
    nums2 = [-1, 3], and both elements are odd. Thus, the answer is true.
    Example 2:

    Input: nums1 = [4,6]

    Output: true

    Explanation:

    Choose nums2[0] = nums1[0] = 4.
    Choose nums2[1] = nums1[1] = 6.
    nums2 = [4, 6], and all elements are even. Thus, the answer is true.


    Constraints:

    1 <= n == nums1.length <= 100
    1 <= nums1[i] <= 100
    nums1 consists of distinct integers.

     */
    public boolean uniformArray(int[] nums1) {
        // 如果全是偶数或者全是奇数，直接返回true
        // 否则，如果有一个奇数和一个偶数，那么就可以通过加减其中一个数字得到另一个，所以返回true
        return true;
    }

    public static void main(String[] args) {

        L3875_Construct_Uniform_Parity_Array_I s = new L3875_Construct_Uniform_Parity_Array_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums1 = {2, 3};

        boolean res = s.uniformArray(nums1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}