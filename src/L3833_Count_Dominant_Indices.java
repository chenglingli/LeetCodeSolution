public class L3833_Count_Dominant_Indices {

    /*
    You are given an integer array nums of length n.

    An element at index i is called dominant if: nums[i] > average(nums[i + 1], nums[i + 2], ..., nums[n - 1])

    Your task is to count the number of indices i that are dominant.

    The average of a set of numbers is the value obtained by adding all the numbers together and dividing the sum by the total number of numbers.

    Note: The rightmost element of any array is not dominant.



    Example 1:

    Input: nums = [5,4,3]

    Output: 2

    Explanation:

    At index i = 0, the value 5 is dominant as 5 > average(4, 3) = 3.5.
    At index i = 1, the value 4 is dominant over the subarray [3].
    Index i = 2 is not dominant as there are no elements to its right. Thus, the answer is 2.
    Example 2:

    Input: nums = [4,1,2]

    Output: 1

    Explanation:

    At index i = 0, the value 4 is dominant over the subarray [1, 2].
    At index i = 1, the value 1 is not dominant.
    Index i = 2 is not dominant as there are no elements to its right. Thus, the answer is 1.


    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int dominantIndices(int[] nums) {

        int[] sum = new int[nums.length];
        int n = nums.length;

        sum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > (sum[i + 1] * 1.0 / (n - i - 1)))
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L3833_Count_Dominant_Indices s = new L3833_Count_Dominant_Indices();
        long sysDate1 = System.currentTimeMillis();

//        int[] nums = {5, 4, 3};
        int[] nums = {4, 1, 2};
        int res = s.dominantIndices(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}