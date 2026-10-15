public class L3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I {


    /*
    You are given a binary array nums.

    You can do the following operation on the array any number of times (possibly zero):

    Choose any 3 consecutive elements from the array and flip all of them.
    Flipping an element means changing its value from 0 to 1, and from 1 to 0.

    Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.



    Example 1:

    Input: nums = [0,1,1,1,0,0]

    Output: 3

    Explanation:
    We can do the following operations:

    Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
    Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
    Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
    Example 2:

    Input: nums = [0,1,1,1]

    Output: -1

    Explanation:
    It is impossible to make all elements equal to 1.



    Constraints:

    3 <= nums.length <= 10^5
    0 <= nums[i] <= 1

     */
    public int minOperations(int[] nums) {
        /*
        题意，对于一个二进制值的数组，做多少次反转可以全部变为1，或者无法变为1

        思路：
        1. 遍历数组，找到第一个0的位置，然后翻转
        2. 翻转后，再次遍历数组，找到第一个0的位置，然后翻转

         */

        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                count++;
                flip(nums, i);
            }
        }

        return (nums[n - 1] == 1 && nums[n - 2] == 1)
                ? count : -1;
    }

    private void flip(int[] nums, int index) {
        for (int i = index; i < index + 3; i++) {
            nums[i] ^= 1;
        }
    }

    public int minOperations2(int[] nums) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                count++;
            }
        }

        return (nums[n - 1] == 1 && nums[n - 2] == 1)
                ? count : -1;
    }

    public static void main(String[] args) {

        L3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I s = new L3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {0, 1, 1, 1, 0, 0};
        int[] nums = {0, 1, 1, 1};
        int res = s.minOperations(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}