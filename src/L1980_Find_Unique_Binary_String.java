public class L1980_Find_Unique_Binary_String {

    /*

    Given an array of strings nums containing n unique binary strings each of length n,
    return a binary string of length n that does not appear in nums.
    If there are multiple answers, you may return any of them.

    Example 1:

    Input: nums = ["01","10"]
    Output: "11"
    Explanation: "11" does not appear in nums. "00" would also be correct.

    Example 2:

    Input: nums = ["00","01"]
    Output: "11"
    Explanation: "11" does not appear in nums. "10" would also be correct.

    Example 3:

    Input: nums = ["111","011","001"]
    Output: "101"
    Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.


    Constraints:

    n == nums.length
    1 <= n <= 16
    nums[i].length == n
    nums[i] is either '0' or '1'.
    All the strings of nums are unique.

     */

    /*
    解法1，从0到2^n遍历，然后判断是否存在，不存在就返回。
    时间复杂度O(2^n)，空间复杂度O(1)
     */
    public String findDifferentBinaryString(String[] nums) {

        int n = nums[0].length();
        for (int i = 0; i < Math.pow(2, n); i++) {
            StringBuilder str = new StringBuilder(Integer.toBinaryString(i));
            while (str.length() < n) {
                str.insert(0, "0");
            }
            if (!contains(nums, str.toString())) {
                return str.toString();
            }
        }

        return "";
    }

    private boolean contains(String[] nums, String str) {
        for (String num : nums) {
            if (num.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /*
    另一种实现逻辑
    每个数字里面取一位反，组成一个数字，这个数字和出现的任何一个数字都不一样，所以用这个数字一定能找到答案

    因为位数n，数字个数n，决定了这个方案可行性。否则是不可以这么做。

    时间复杂度O(n)，空间复杂度O(1)
     */
    public String findDifferentBinaryString2(String[] nums) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        L1980_Find_Unique_Binary_String s = new L1980_Find_Unique_Binary_String();
        long sysDate1 = System.currentTimeMillis();

        String[] nums = {"10", "01"};
        String res = s.findDifferentBinaryString2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}