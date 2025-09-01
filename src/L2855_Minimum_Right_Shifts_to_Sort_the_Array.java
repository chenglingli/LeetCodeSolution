import java.util.ArrayList;
import java.util.List;

public class L2855_Minimum_Right_Shifts_to_Sort_the_Array {

    /*

    You are given a 0-indexed array nums of length n containing distinct positive integers.
    Return the minimum number of right shifts required to sort nums and -1 if this is not possible.

    A right shift is defined as shifting the element at index i to index (i + 1) % n, for all indices.



    Example 1:

    Input: nums = [3,4,5,1,2]
    Output: 2
    Explanation:
    After the first right shift, nums = [2,3,4,5,1].
    After the second right shift, nums = [1,2,3,4,5].
    Now nums is sorted; therefore the answer is 2.
    Example 2:

    Input: nums = [1,3,5]
    Output: 0
    Explanation: nums is already sorted therefore, the answer is 0.
    Example 3:

    Input: nums = [2,1,4]
    Output: -1
    Explanation: It's impossible to sort the array using right shifts.


    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    nums contains distinct integers.

     */
    public int minimumRightShifts(List<Integer> nums) {
        // 需要判断是否有序
        // 如果无序，则-1
        // 如果有序，则找到最小值的下标，然后答案为n-minIndex
        // 如果第一位为最小值，且有序，则答案为0

        int n = nums.size();

        // 假定排好序
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                minIndex = i;
                break;
            }
        }
        if (minIndex == 0) {
            return 0;
        }

        for (int i = minIndex + 1; i < n; i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                return -1;
            }
        }
        if (nums.get(n - 1) > nums.get(0)) {
            return -1;
        }

        return n - minIndex;
    }

    public static void main(String[] args) {

        L2855_Minimum_Right_Shifts_to_Sort_the_Array s = new L2855_Minimum_Right_Shifts_to_Sort_the_Array();
        long sysDate1 = System.currentTimeMillis();


        List<Integer> nums = new ArrayList<>();
//        nums.add(3);
//        nums.add(4);
//        nums.add(5);
//        nums.add(1);
//        nums.add(2);

        nums.add(2);
        nums.add(1);
        nums.add(4);

        int res = s.minimumRightShifts(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}