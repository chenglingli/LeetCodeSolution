import java.util.Arrays;

public class L1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {


    /*
    2 <= nums.length <= 500
    0 <= nums[i] <= 100
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] res = new int[nums.length];

        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int x = binarySearch(numsCopy, cur);
            res[i] = x;
        }

        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int uniq[] = new int[101];
        for (int i = 0; i < nums.length; i++) {
            uniq[nums[i]]++;
        }
        for (int i = 1; i < uniq.length - 1; i++) {
            uniq[i] = uniq[i - 1] + uniq[i];
        }

        int smaller[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                smaller[i] = 0;
            } else {
                smaller[i] = uniq[nums[i] - 1];
            }
        }

        return smaller;

    }


    public static void main(String[] args) {

        L1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number s = new L1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {8, 1, 2, 2, 3};
        // [4,0,1,1,3]

        // int[] nums = {7, 7, 7, 7};
        // [0,0,0,0]

        int[] res = s.smallerNumbersThanCurrent2(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}