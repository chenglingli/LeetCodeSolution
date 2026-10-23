public class L2317_Maximum_XOR_After_Operations {

    /*

    You are given a 0-indexed integer array nums.
    In one operation, select any non-negative integer x and an index i, then update nums[i] to be equal to nums[i] AND (nums[i] XOR x).

    Note that AND is the bitwise AND operation and XOR is the bitwise XOR operation.

    Return the maximum possible bitwise XOR of all elements of nums after applying the operation any number of times.



    Example 1:
    Input: nums = [3,2,4,6]
    Output: 7
    Explanation: Apply the operation with x = 4 and i = 3, num[3] = 6 AND (6 XOR 4) = 6 AND 2 = 2.
    Now, nums = [3, 2, 4, 2] and the bitwise XOR of all the elements = 3 XOR 2 XOR 4 XOR 2 = 7.
    It can be shown that 7 is the maximum possible bitwise XOR.
    Note that other operations may be used to achieve a bitwise XOR of 7.

    Example 2:
    Input: nums = [1,2,3,9,2]
    Output: 11
    Explanation: Apply the operation zero times.
    The bitwise XOR of all the elements = 1 XOR 2 XOR 3 XOR 9 XOR 2 = 11.
    It can be shown that 11 is the maximum possible bitwise XOR.


    Constraints:

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^8

     */
    public int maximumXOR(int[] nums) {

        /*
        
        操作 nums[i] AND (nums[i] XOR x) 等价于 nums[i] AND (NOT x)。
        某一位原来是 0，结果仍是 0；原来是 1，则可以保留，也可以被 x 的对应位清掉。所以每个数只能关掉自己已有的 1，不能凭空造出新的 1。

    因此某一位能不能出现在最终异或里，只取决于数组里有没有至少一个数拥有这一位：

    有，就在其中一个数上保留它，其余数把这一位清掉，异或结果里这一位就是 1。
    没有，任何操作都变不出这一位。
    各位互不干扰，所以最大异或就是全体元素的按位或。

        */
        int res = 0;
        for (int num : nums) {
            res |= num;
        }
        return res;
    }

    public static void main(String[] args) {

        L2317_Maximum_XOR_After_Operations s =
                new L2317_Maximum_XOR_After_Operations();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 2, 4, 6};
        int res = s.maximumXOR(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}