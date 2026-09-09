public class L2221_Find_Triangular_Sum_of_an_Array {

    /*
    You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).

    The triangular sum of nums is the value of the only element present in nums after the following process terminates:

    Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
    For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
    Replace the array nums with newNums.
    Repeat the entire process starting from step 1.
    Return the triangular sum of nums.

    Example 1:
    Input: nums = [1,2,3,4,5]
    Output: 8

    Explanation:
    The above diagram depicts the process from which we obtain the triangular sum of the array.

    Example 2:
    Input: nums = [5]
    Output: 5
    Explanation:
    Since there is only one element in nums, the triangular sum is the value of that element itself.


    Constraints:
    1 <= nums.length <= 1000
    0 <= nums[i] <= 9

     */
    public int triangularSum(int[] nums) {
        int count = nums.length;

        while (count > 1) {
            for (int i = 0; i < count - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            count--;
        }

        return nums[0];
    }

    private static final int[][] COMB_MOD_5 = {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 2, 1, 0, 0},
            {1, 3, 3, 1, 0},
            {1, 4, 1, 4, 1}
    };

    private int nCkMod2(int n, int k) {
        // C(n,k) is odd if all set bits of k are present in n.
        return (k & ~n) == 0 ? 1 : 0;
    }

    private int nCkMod5(int n, int k) {
        int result = 1;

        while (n > 0 || k > 0) {
            int nDigit = n % 5;
            int kDigit = k % 5;

            if (kDigit > nDigit) {
                return 0;
            }

            result =
                    result * COMB_MOD_5[nDigit][kDigit] % 5;

            n /= 5;
            k /= 5;
        }

        return result;
    }

    private int nCkMod10(int n, int k) {
        int remainder2 = nCkMod2(n, k);
        int remainder5 = nCkMod5(n, k);

        // Numbers in [0,9] with remainder5 are:
        // remainder5 and remainder5 + 5.
        // Choose the one with the required parity.
        if (remainder5 % 2 == remainder2) {
            return remainder5;
        }

        return remainder5 + 5;
    }


    public int triangularSum2(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0] % 10;

        long ans = 0l;
        for (int i = 0; i < n; i++) {
            ans += (long) nCkMod10(n - 1, i) * (long) nums[i];
            ans = ans % 10;
        }

        return (int) ans % 10;
    }

    public static void main(String[] args) {

        L2221_Find_Triangular_Sum_of_an_Array s =
                new L2221_Find_Triangular_Sum_of_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 5};
        int res = s.triangularSum2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}