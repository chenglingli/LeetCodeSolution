public class L2778_Sum_of_Squares_of_Special_Elements {

    public int sumOfSquares(int[] nums) {

        int n = nums.length;
        int ans = 0;
        int i = 0;
        
        while (i < n) {
            if (n % (i+1) == 0) {
                ans += nums[i] * nums[i];
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2778_Sum_of_Squares_of_Special_Elements s = new L2778_Sum_of_Squares_of_Special_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 7, 1, 19, 18, 3};

        int res = s.sumOfSquares(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}