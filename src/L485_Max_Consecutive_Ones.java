public class L485_Max_Consecutive_Ones {

    /*
    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int curRes = 0;

        int i = 0;
        while (i < nums.length) {

            if (nums[i] == 1) {
                while (i < nums.length && nums[i] == 1) {
                    i++;
                    curRes++;
                }
                res = Math.max(curRes, res);
                curRes = 0;
            }

            i++;
        }

        return res;
    }

    public static void main(String[] args) {

        L485_Max_Consecutive_Ones s = new L485_Max_Consecutive_Ones();
        long sysDate1 = System.currentTimeMillis();

//        int[] nums = {1, 1, 0, 1, 1, 1};
//        int[] nums = {1};
        int[] nums = {0,1};
        int res = s.findMaxConsecutiveOnes(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}