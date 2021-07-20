import java.util.Arrays;

public class L153_Find_Minimum_in_Rotated_Sorted_Array {

    // Given the sorted rotated array nums of unique elements,
    // return the minimum element of this array.

    public int findMin(int[] nums) {
        int res = 0;
        if (nums.length <= 0) {
            return res;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {

        L153_Find_Minimum_in_Rotated_Sorted_Array s = new L153_Find_Minimum_in_Rotated_Sorted_Array();

        long sysDate1 = System.currentTimeMillis();
        int[] nums = {4,5,6,7,-1,1,2};
        int res = s.findMin(nums);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}