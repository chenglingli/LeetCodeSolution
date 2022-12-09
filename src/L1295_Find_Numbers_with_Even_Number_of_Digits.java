public class L1295_Find_Numbers_with_Even_Number_of_Digits {

    /*
    1 <= nums.length <= 500
    1 <= nums[i] <= 10^5
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int cur : nums) {
            if (cur >= 10 && cur <= 99 || cur >= 1000 && cur <= 9999 || cur >= 100000) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L1295_Find_Numbers_with_Even_Number_of_Digits s = new L1295_Find_Numbers_with_Even_Number_of_Digits();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 234, 234, 2323, 10};
        int res = s.findNumbers(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}