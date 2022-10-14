import java.util.ArrayList;
import java.util.List;

public class L724_Find_Pivot_Index {

    public int pivotIndex(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum - nums[0] == 0) {
            return 0;
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1 ;i < nums.length; i++) {

            leftSum += nums[i-1];
            rightSum = sum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        L724_Find_Pivot_Index s = new L724_Find_Pivot_Index();

        long sysDate1 = System.currentTimeMillis();

//        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {2,1,-1};
//        int[] nums = {1,2,3};
        int[] nums = {-1,1,2};
        int res = s.pivotIndex(nums);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}