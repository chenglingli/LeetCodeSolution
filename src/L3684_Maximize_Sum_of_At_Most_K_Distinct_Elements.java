import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3684_Maximize_Sum_of_At_Most_K_Distinct_Elements {

    /*
    You are given a positive integer array nums and an integer k.

    Choose at most k elements from nums so that their sum is maximized.
    However, the chosen numbers must be distinct.

    Return an array containing the chosen numbers in strictly descending order.



    Example 1:

    Input: nums = [84,93,100,77,90], k = 3

    Output: [100,93,90]

    Explanation:

    The maximum sum is 283, which is attained by choosing 93, 100 and 90. We rearrange them in strictly descending order as [100, 93, 90].

    Example 2:

    Input: nums = [84,93,100,77,93], k = 3

    Output: [100,93,84]

    Explanation:

    The maximum sum is 277, which is attained by choosing 84, 93 and 100.
    We rearrange them in strictly descending order as [100, 93, 84]. We cannot choose 93, 100 and 93 because the chosen numbers must be distinct.

    Example 3:

    Input: nums = [1,1,1,2,2,2], k = 6

    Output: [2,1]

    Explanation:

    The maximum sum is 3, which is attained by choosing 1 and 2. We rearrange them in strictly descending order as [2, 1].



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 10^9
    1 <= k <= nums.length
     */
    public int[] maxKDistinct(int[] nums, int k) {

        Arrays.sort(nums);

        List<Integer> resList = new ArrayList<>();

        int x = 0;

        for (int i = nums.length - 1; i >= 0 && x < k; ) {

            int temp = nums[i];
            i--;
            while (i >= 0 && nums[i] == temp) {
                i--;
            }

            resList.add(temp);
            x++;
        }

        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] maxKDistinct2(int[] nums, int k) {

        int[] a = new int[k];
        a[0] = max(nums);
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (j >= k) break;
            int x = max(nums);
            if (x != a[j - 1])
                a[j++] = x;
        }
        return Arrays.copyOf(a, j);

    }

    public int max(int[] nums) {
        int c = nums[0], ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > c) {
                c = nums[i];
                ind = i;
            }
        }
        nums[ind] = -1;
        return c;
    }

    public static void main(String[] args) {

        L3684_Maximize_Sum_of_At_Most_K_Distinct_Elements s = new L3684_Maximize_Sum_of_At_Most_K_Distinct_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {84, 93, 100, 77, 90};
        int k = 3;

        int[] res = s.maxKDistinct(nums, k);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}