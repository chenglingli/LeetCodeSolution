public class L2210_Count_Hills_and_Valleys_in_an_Array {

    /*
    3 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public int countHillValley(int[] nums) {

        int direction = 0;
        int n = nums.length;
        int ans = 0;

        int i = 1;
        while (i < n) {

            if (nums[i] > nums[i - 1]) {
                if (direction == 0 || direction == -1) {
                    ans++;
                }
                direction = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (direction == 0 || direction == 1) {
                    ans++;
                }
                direction = -1;
            }

            i++;
        }

        if (ans > 0) {
            return ans - 1;
        }
        return 0;
    }

    public static void main(String[] args) {

        L2210_Count_Hills_and_Valleys_in_an_Array s =
                new L2210_Count_Hills_and_Valleys_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 4, 1, 1, 6, 5};
        int res = s.countHillValley(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}