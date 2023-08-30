import java.util.Arrays;

public class L2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements {

    /*
    1 <= nums.length <= 100
    -10^5 <= nums[i] <= 10^5
     */
    public int countElements(int[] nums) {

        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;

        int i = 0;
        int j = n - 1;

        while (i + 1 < n && nums[i] == nums[i + 1]) i++;
        while (j - 1 >= 0 && nums[j] == nums[j - 1]) j--;

        return Math.max(j - i - 1, 0);
    }

    public int countElements2(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int count = 0;
        for (int num : nums) {
            if (num > min && num < max)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        L2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements s =
                new L2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {11, 7, 2, 15};
        int[] nums = {1, 1, 2, 2, 3};
        int res = s.countElements(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}