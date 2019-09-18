public class L303_Range_Sum_Query_Immutable {

    /**

     Given an integer array nums,
     find the sum of the elements between indices i and j (i ≤ j), inclusive.

     Example:
     Given nums = [-2, 0, 3, -5, 2, -1]

     sumRange(0, 2) -> 1
     sumRange(2, 5) -> -1
     sumRange(0, 5) -> -3
     Note:
     You may assume that the array does not change.
     There are many calls to sumRange function.

     */
    //sum{i]中存储[0, i - 1]的值
    private int[] sum;
    public void NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }
    //[i, j] = [0, j] - [0, i - 1]
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

    public static void main(String[] args) {

        int [] nums = {-2, 0, 3, -5, 2, -1};

        L303_Range_Sum_Query_Immutable s = new L303_Range_Sum_Query_Immutable();
        long sysDate1 = System.currentTimeMillis();

        int[] cost = {2,7,9,3,1};

        int res = s.sumRange(1,2 );
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}