public class L4010_Maximize_Pair_Strength_Using_GCD {

    /*
    You are given an integer array nums.

    Choose exactly one pair of distinct indices i and j. The strength of the pair is defined as (nums[i] * nums[j]) / gcd(nums[i], nums[j])2.

    Return the maximum strength over all possible pairs.



    Example 1:

    Input: nums = [2,3,5]

    Output: 15

    Explanation:

    Choosing i = 1 and j = 2 gives strength (3 * 5) / gcd(3, 5)2 = 15 / 1 = 15, which is the maximum over all pairs.

    Example 2:

    Input: nums = [4,6,8]

    Output: 12

    Explanation:

    Choosing i = 1 and j = 2 gives strength (6 * 8) / gcd(6, 8)2 = 48 / 4 = 12, which is the maximum over all pairs.

    Example 3:

    Input: nums = [3,3]

    Output: 1

    Explanation:

    Choosing i = 0 and j = 1 gives strength (3 * 3) / gcd(3, 3)2 = 9 / 9 = 1, the maximum over all pairs.



    Constraints:

    2 <= nums.length <= 2000
    1 <= nums[i] <= 10^5
     */

    public long maxPairStrength(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ans = Math.max(ans, strength(nums[i], nums[j]));
            }
        }

        return ans;
    }

    private long strength(int x, int y) {
        return ((long) x * y) / (int) Math.pow(gcd(x, y), 2);
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }


    public long maxPairStrength2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long max = 0;
        int limit = Math.max(0, n - 10);
        for (int i = n - 1; i >= limit; i--) {
            for (int j = i - 1; j >= limit; j--) {
                long cur = cal(nums[i], nums[j]);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;

    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long cal(long a, long b) {
        long g = gcd(a, b);
        return (a * b) / (g * g);
    }


    public static void main(String[] args) {

        L4010_Maximize_Pair_Strength_Using_GCD s = new L4010_Maximize_Pair_Strength_Using_GCD();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 3, 5};
        long res = s.maxPairStrength(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}