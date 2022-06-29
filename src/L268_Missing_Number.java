public class L268_Missing_Number {

    public int missingNumber(int[] nums) {

        int[] res = new int[nums.length + 1];
        for (int num : nums) res[num] = 1;

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) return i;
        }

        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int sum1 = nums.length * (nums.length + 1) / 2;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        return sum1 - sum2;
    }

    public static void main(String[] args) {

        L268_Missing_Number s = new L268_Missing_Number();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0,1,3};
        int res = s.missingNumber(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}