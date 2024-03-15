public class L080_Remove_Duplicates_from_Sorted_Array_II {

    /*
    1 <= nums.length <= 3 * 10^4
    -10^4 <= nums[i] <= 10^4

    Initialization:
        Initialize j to 1 since the first element (at index 0)
        is always considered part of the modified array.

    Iteration:
        Loop through the array starting from index 1 (i.e., i = 1).
        Compare the current element at index i with the element two positions behind at index j - 2.
        If they are the same,
            it means there are already two occurrences of this element in the modified array,
            so skip adding another.
        If they are different,
            add the current element to the modified array at position j and increment j.

    Final Result:
        The final length of the modified array is equal to j,
        and the modified array contains elements adhering to the constraint.


    双指针法，left和right

    left 表示当前已经处理好的元素的最后一个位置，right 用来遍历整个数组。
    对比 left - 2 和 right 位置的元素是否相等。

    如果相等，则说明right所在元素已经重复至少两次了，不需要加入到left位置。
    如果不相等，则说明right所在元素可以加入到left位置。

     */
    public int removeDuplicates(int[] nums) {
        int left = 1;

        for (int right = 1; right < nums.length; right++) {
            if (left == 1 || nums[right] != nums[left - 2]) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        L080_Remove_Duplicates_from_Sorted_Array_II s = new L080_Remove_Duplicates_from_Sorted_Array_II();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int x = s.removeDuplicates(nums);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}