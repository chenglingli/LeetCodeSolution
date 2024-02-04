public class L1437_Check_If_All_Are_at_Least_Length_K_Places_Away {

    public boolean kLengthApart(int[] nums, int k) {

        int curCount = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 1) {
                break;
            }
        }
        i++;

        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                curCount++;
            } else {
                if (curCount < k) {
                    return false;
                }
                curCount = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L1437_Check_If_All_Are_at_Least_Length_K_Places_Away s = new L1437_Check_If_All_Are_at_Least_Length_K_Places_Away();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {0, 1, 0, 1};
        //        int k = 1;

        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1, 0};
        int k = 2;

        boolean res = s.kLengthApart(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}