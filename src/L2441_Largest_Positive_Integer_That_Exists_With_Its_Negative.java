public class L2441_Largest_Positive_Integer_That_Exists_With_Its_Negative {

    /*
    1 <= nums.length <= 1000
    -1000 <= nums[i] <= 1000
    nums[i] != 0
     */
    public int findMaxK(int[] nums) {
        int[] count = new int[1001];
        int ans = -1;

        for (int x : nums) {
            int n = Math.abs(x);

            if (count[n] != 0) {
                if (count[n] == 1 && x < 0 || count[n] == -1 && x > 0) {
                    count[n] = 2;
                    ans = Math.max(ans, n);
                }
            } else {
                count[n] = x / n;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2441_Largest_Positive_Integer_That_Exists_With_Its_Negative s = new L2441_Largest_Positive_Integer_That_Exists_With_Its_Negative();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {-1, 10, 6, 7, -7, 1};
        int res = s.findMaxK(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}