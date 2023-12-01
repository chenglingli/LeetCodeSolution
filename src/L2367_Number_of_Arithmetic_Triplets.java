public class L2367_Number_of_Arithmetic_Triplets {

    /*

    3 <= nums.length <= 200
    0 <= nums[i] <= 200
    1 <= diff <= 50
    nums is strictly increasing.

     */
    public int arithmeticTriplets(int[] nums, int diff) {

        int[] digit = new int[201];
        for (int x : nums) {
            digit[x] = 1;
        }

        int ans = 0;
        for (int i = 200; i >= diff * 2; i--) {
            if (digit[i] == 0) {
                continue;
            }

            if (digit[i - diff] == 1 && digit[i - diff - diff] == 1) {
                ans++;
            }
        }

        return ans;
    }


    public int arithmeticTriplets2(int[] nums, int diff) {

        int[] diffPairExists = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diffPairExists[i] = -1;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            int calculatedDiff = nums[j] - nums[i];
            if (calculatedDiff == diff) {
                diffPairExists[i] = j;
                i++;
                j++;
            } else if (calculatedDiff < diff) {
                j++;
            } else {
                i++;
            }
        }
        int count = 0;
        for (int pair : diffPairExists) {
            if (pair != -1) {
                int nextIndex = diffPairExists[pair];
                if (nextIndex != -1) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L2367_Number_of_Arithmetic_Triplets s =
                new L2367_Number_of_Arithmetic_Triplets();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {0, 1, 4, 6, 7, 10};
        //        int diff = 3;

        int[] nums = {0, 1, 2};
        int diff = 1;

        int res = s.arithmeticTriplets(nums, diff);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}