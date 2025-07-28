import java.util.Arrays;

public class L3427_Sum_of_Variable_Length_Subarrays {

    /*
    You are given an integer array nums of size n. For each index i where 0 <= i < n,
        define a subarray nums[start ... i] where start = max(0, i - nums[i]).

    Return the total sum of all elements from the subarray defined for each index in the array.



    Example 1:

    Input: nums = [2,3,1]

    Output: 11

    Explanation:

    i	Subarray	Sum
    0	nums[0] = [2]	2
    1	nums[0 ... 1] = [2, 3]	5
    2	nums[1 ... 2] = [3, 1]	4
    Total Sum	 	11
    The total sum is 11. Hence, 11 is the output.

    Example 2:

    Input: nums = [3,1,1,2]

    Output: 13

    Explanation:

    i	Subarray	Sum
    0	nums[0] = [3]	3
    1	nums[0 ... 1] = [3, 1]	4
    2	nums[1 ... 2] = [1, 1]	2
    3	nums[1 ... 3] = [1, 1, 2]	4
    Total Sum	 	13
    The total sum is 13. Hence, 13 is the output.



    Constraints:

    1 <= n == nums.length <= 100
    1 <= nums[i] <= 1000
     */
    public int subarraySum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                sum += nums[j];
            }
        }

        return sum;
    }

    /*

    we use the prefix sum of nums to compute the sum of the range from some indices nums[j]..nums[i] where j<i.
    At each step we add the previous value in the array which names nums[i] equal to the sum of the array up to index i.

    When we need to exclude a range,
        for example if we need the sum of nums[j..i] where j = max(0, i - nums[i]),
        then we subtract nums[j - 1] if j>0.
        If for every index i nums[i] == sum(nums[..i]) then sum(nums[j..i] == nums[i] - nums[j - 1] if j > 0 else 0).

        Note that if j=0 then we want sum(nums[..i]).

    使用前缀和
    nums[i] = nums[i - 1] + nums[i]; 这样num[i] 实际上就是 nums[0..i]的和

    j = i - nums[i] - 1;
    如果j < 0, 那么就是从nums[0] 到 nums[i];
    如果j >= 0, 那么就是从nums[j] 到 nums[i];

     */
    public int subarraySum2(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int j = i - nums[i];
            nums[i] += nums[i - 1];
            res += nums[i] - ((j >= 1) ? nums[j - 1] : 0);
        }

        return res;
    }

    public static void main(String[] args) {

        L3427_Sum_of_Variable_Length_Subarrays s = new L3427_Sum_of_Variable_Length_Subarrays();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 1, 1, 2};

        int res = s.subarraySum2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}