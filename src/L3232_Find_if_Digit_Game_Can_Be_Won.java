public class L3232_Find_if_Digit_Game_Can_Be_Won {

    /*
    1 <= nums.length <= 100
    1 <= nums[i] <= 99
     */
    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        int doubleSum = 0;
        for (int x : nums) {
            sum += x;
            if (x > 9) {
                doubleSum += x;
            }
        }

        return sum - doubleSum != doubleSum;
    }

    public static void main(String[] args) {

        L3232_Find_if_Digit_Game_Can_Be_Won s = new L3232_Find_if_Digit_Game_Can_Be_Won();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 10};
        boolean res = s.canAliceWin(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}