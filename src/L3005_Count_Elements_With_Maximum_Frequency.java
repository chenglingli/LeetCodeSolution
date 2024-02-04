public class L3005_Count_Elements_With_Maximum_Frequency {

    /*
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public int maxFrequencyElements(int[] nums) {

        int[] count = new int[101];
        int max = 0;

        for (int x : nums) {
            count[x]++;
            max = Math.max(max, count[x]);
        }

        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            if (count[i] == max) {
                ans += count[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L3005_Count_Elements_With_Maximum_Frequency s = new L3005_Count_Elements_With_Maximum_Frequency();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 5, 5};
        int res = s.maxFrequencyElements(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}