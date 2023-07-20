public class L2016_Maximum_Difference_Between_Increasing_Elements {


    /*
    n == nums.length
    2 <= n <= 1000
    1 <= nums[i] <= 109
     */
    public int maximumDifference(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] > res) {
                    res = nums[j] - nums[i];
                }
            }
        }

        return res == 0 ? -1 : res;
    }

    public int maximumDifference2(int[] nums) {

        int minVal = nums[0];
        int res = nums[1] - nums[0];

        for (int j = 1; j < nums.length; j++) {
            res = Math.max(res, nums[j] - minVal);
            minVal = Math.min(minVal, nums[j]);
        }

        if (res <= 0) return -1;
        return res;
    }

    public static void main(String[] args) {

        L2016_Maximum_Difference_Between_Increasing_Elements s = new L2016_Maximum_Difference_Between_Increasing_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {999, 997, 980, 976, 948, 940, 938, 928, 924, 917, 907, 907, 881, 878, 864, 862, 859, 857, 848, 840, 824, 824, 824, 805, 802, 798, 788, 777, 775, 766, 755, 748, 735, 732, 727, 705, 700, 697, 693, 679, 676, 644, 634, 624, 599, 596, 588, 583, 562, 558, 553, 539, 537, 536, 509, 491, 485, 483, 454, 449, 438, 425, 403, 368, 345, 327, 287, 285, 270, 263, 255, 248, 235, 234, 224, 221, 201, 189, 187, 183, 179, 168, 155, 153, 150, 144, 107, 102, 102, 87, 80, 57, 55, 49, 48, 45, 26, 26, 23, 15};
        // int[] nums = {5, 2, 10, 1};
        int res = s.maximumDifference(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}