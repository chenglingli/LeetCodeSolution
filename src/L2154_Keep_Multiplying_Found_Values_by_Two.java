public class L2154_Keep_Multiplying_Found_Values_by_Two {

    /*
    1 <= nums.length <= 1000
    1 <= nums[i], original <= 1000
     */
    public int findFinalValue(int[] nums, int original) {

        int[] count = new int[1001];
        for (int x : nums) {
            count[x] = 1;
        }

        int temp = original;
        while (temp <= 1000 && count[temp] == 1) {
            temp *= 2;
        }
        return temp;
    }

    public int findFinalValue2(int[] nums, int original) {

        while (true) {
            if (find(nums, original)) {
                original = original * 2;
            }
            else {
                return original;
            }
        }

    }

    boolean find(int[] arr, int original) {
        for (int j : arr) {
            if (j == original) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L2154_Keep_Multiplying_Found_Values_by_Two s =
                new L2154_Keep_Multiplying_Found_Values_by_Two();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {161, 28, 640, 264, 81, 561, 320, 2, 61, 244, 183, 108, 773, 61, 976, 122, 988, 2, 370, 392, 488, 375, 349, 432, 713, 563};
        int original = 61;
        int res = s.findFinalValue(nums, original);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}