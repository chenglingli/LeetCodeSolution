import java.util.HashMap;
import java.util.Map;

public class L3411_Maximum_Subarray_With_Equal_Products {

    /*
    You are given an array of positive integers nums.

    An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:

    prod(arr) is the product of all elements of arr.
    gcd(arr) is the GCD of all elements of arr.
    lcm(arr) is the LCM of all elements of arr.
    Return the length of the longest product equivalent subarray of nums.


    Example 1:

    Input: nums = [1,2,1,2,1,1,1]

    Output: 5

    Explanation:

    The longest product equivalent subarray is [1, 2, 1, 1, 1],
        where prod([1, 2, 1, 1, 1]) = 2, gcd([1, 2, 1, 1, 1]) = 1, and lcm([1, 2, 1, 1, 1]) = 2.

    Example 2:

    Input: nums = [2,3,4,5,6]

    Output: 3

    Explanation:

    The longest product equivalent subarray is [3, 4, 5].

    Example 3:

    Input: nums = [1,2,3,1,4,5,1]

    Output: 5


    Constraints:

    2 <= nums.length <= 100
    1 <= nums[i] <= 10
     */
    public int maxLength(int[] nums) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = prod(nums, i, j);
                int gcd = gcdArray(nums, i, j);
                int lcm = lcmArray(nums, i, j);

                if (prod == lcm * gcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int prod(int[] nums, int start, int end) {
        int prod = 1;
        for (int i = start; i <= end; i++) {
            prod *= nums[i];
        }
        return prod;
    }

    private int gcdArray(int[] nums, int start, int end) {
        int gcd = nums[start];
        for (int i = start + 1; i <= end; i++) {
            gcd = gcd(nums[i], gcd);
        }
        return gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcmArray(int[] nums, int start, int end) {
        int lcm = nums[start];
        for (int i = start + 1; i <= end; i++) {
            lcm = lcm(nums[i], lcm);
        }

        return lcm;
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }


    /*

    优化的解法：
    为了避免重复计算，我们可以使用一个额外的变量来存储当前子数组的乘积、最大公约数和最小公倍数。
    这样，我们就可以在遍历数组时动态更新这些值，而不需要每次都重新计算整个子数组的乘积、最大公约数和最小公倍数。
    这种方法可以显著减少计算量，从而提高算法的效率。
    这种方法的时间复杂度为O(n^2)，但在实际应用中，由于避免了重复计算，其性能通常优于原始的双重循环方法。
    这种方法的空间复杂度为O(1)，因为我们只使用了几个额外的变量来存储中间结果。

    i，即左边坐标变动的时机，即当 prod != G * L 时，就应该停止扩展子数组。
    为什么可以这么定义呢？

    因为：
    prod == (long) G * L
    这个等式成立的条件非常严格：数组中的所有元素必须是两两互质的 (pairwise coprime)。
     */

    public int maxLength2(int[] nums) {

        int n = nums.length;
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            long prod = nums[i];
            int G = nums[i];
            int L = nums[i];

            if (prod == (long) G * L) {
                maxi = Math.max(maxi, 1);
            }

            for (int j = i + 1; j < n; j++) {
                if (prod * nums[j] > Integer.MAX_VALUE)
                    break;

                prod *= nums[j];
                G = gcd(G, nums[j]);
                L = lcm(L, nums[j]);

                if (prod == (long) G * L)
                    maxi = Math.max(maxi, j - i + 1);
                else
                    break;
            }
        }

        return maxi;
    }


    public static void main(String[] args) {

        L3411_Maximum_Subarray_With_Equal_Products s = new L3411_Maximum_Subarray_With_Equal_Products();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 3, 4, 5, 6};

        int res = s.maxLength(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}