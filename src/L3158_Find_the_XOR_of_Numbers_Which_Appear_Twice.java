public class L3158_Find_the_XOR_of_Numbers_Which_Appear_Twice {

    /*

    You are given an array nums, where each number in the array appears either once or twice.

    Return the bitwise XOR of all the numbers that appear twice in the array, or 0 if no number appears twice.



    Example 1:

    Input: nums = [1,2,1,3]

    Output: 1

    Explanation:

    The only number that appears twice in nums is 1.

    Example 2:

    Input: nums = [1,2,3]

    Output: 0

    Explanation:

    No number appears twice in nums.

    Example 3:

    Input: nums = [1,2,2,1]

    Output: 3

    Explanation:

    Numbers 1 and 2 appeared twice. 1 XOR 2 == 3.



    Constraints:

    1 <= nums.length <= 50
    1 <= nums[i] <= 50
    Each number in nums appears either once or twice.

     */
    public int duplicateNumbersXOR(int[] nums) {
        int [] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }

        int xor = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2)
                xor ^= i;
        }

        return xor;
    }

    public int duplicateNumbersXOR2(int[] nums) {
        long mask = 0;
        int res = 0;

        for(int num : nums){
            long bit = 1L << num;
            if((mask & bit) != 0){
                res = res ^ num;
            }else{
                mask = mask | bit;
            }
        }
        return (int)res;
    }


    public static void main(String[] args) {

        L3158_Find_the_XOR_of_Numbers_Which_Appear_Twice s = new L3158_Find_the_XOR_of_Numbers_Which_Appear_Twice();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 2, 1};

        int res = s.duplicateNumbersXOR(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}