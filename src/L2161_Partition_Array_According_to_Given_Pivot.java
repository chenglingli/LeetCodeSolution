import java.util.Arrays;

public class L2161_Partition_Array_According_to_Given_Pivot {


    /*

    You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

    Every element less than pivot appears before every element greater than pivot.
    Every element equal to pivot appears in between the elements less than and greater than pivot.
    The relative order of the elements less than pivot and the elements greater than pivot is maintained.
    More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
    Return nums after the rearrangement.



    Example 1:

    Input: nums = [9,12,5,10,14,3,10], pivot = 10
    Output: [9,5,3,10,10,12,14]
    Explanation:
    The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
    The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
    The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.
    Example 2:

    Input: nums = [-3,4,3,2], pivot = 2
    Output: [-3,2,4,3]
    Explanation:
    The element -3 is less than the pivot so it is on the left side of the array.
    The elements 4 and 3 are greater than the pivot so they are on the right side of the array.
    The relative ordering of the elements less than and greater than pivot is also maintained. [-3] and [4, 3] are the respective orderings.


    Constraints:

    1 <= nums.length <= 10^5
    -106 <= nums[i] <= 10^6
    pivot equals to an element of nums.

     */
    public int[] pivotArray(int[] nums, int pivot) {

        // 实际上实现一次快速排序的中间一步
        int[] res = new int[nums.length];
        int lessIndex = 0;
        int equalIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[lessIndex++] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                res[equalIndex--] = nums[i];
            }
        }

        while (lessIndex <= equalIndex) {
            res[lessIndex++] = pivot;
        }

        return res;
    }

    public static void main(String[] args) {

        L2161_Partition_Array_According_to_Given_Pivot s = new L2161_Partition_Array_According_to_Given_Pivot();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        int[] res = s.pivotArray(nums, pivot);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}