public class L1995_Count_Special_Quadruplets {


    /*
    4 <= nums.length <= 50
    1 <= nums[i] <= 100

    nums[a] + nums[b] + nums[c] == nums[d], and
    a < b < c < d


     */
    public int countQuadruplets(int[] nums) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int x = k + 1;

                    while (x < n) {
                        if (nums[x] == sum) count++;
                        x++;
                    }
                }
            }
        }

        return count;

    }

    public int countQuadruplets2(int[] nums) {

        int[] dp = new int[201];
        int ans = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[nums[i] + nums[j]]++;
            }

            for (int j = i + 2; j < nums.length; j++) {
                int diff = nums[j] - nums[i + 1];
                if (diff >= 0) {
                    ans += dp[diff];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L1995_Count_Special_Quadruplets s = new L1995_Count_Special_Quadruplets();
        long sysDate1 = System.currentTimeMillis();

        //        int[] patterns = {1, 1, 1, 3, 5};
        int[] patterns = {28, 8, 49, 85, 37, 90, 20, 8};
        int res = s.countQuadruplets(patterns);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}