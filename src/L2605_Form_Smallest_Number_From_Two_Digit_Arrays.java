import java.util.Arrays;

public class L2605_Form_Smallest_Number_From_Two_Digit_Arrays {

    /*
    Given two arrays of unique digits nums1 and nums2,
        return the smallest number that contains at least one digit from each array.


    Example 1:

    Input: nums1 = [4,1,3], nums2 = [5,7]
    Output: 15
    Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2.
    It can be proven that 15 is the smallest number we can have.

    Example 2:
    Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
    Output: 3
    Explanation: The number 3 contains the digit 3 which exists in both arrays.


    Constraints:
    1 <= nums1.length, nums2.length <= 9
    1 <= nums1[i], nums2[i] <= 9
    All digits in each array are unique.

     */
    public int minNumber(int[] nums1, int[] nums2) {

        // 1，公共的最小数
        // 2. 没有公共的数，nums1[0]和 nums2[0]拼的数
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    return nums1[i];
                }
            }
        }

        int ans1 = nums1[0] * 10 + nums2[0];
        int ans2 = nums2[0] * 10 + nums1[0];
        return Math.min(ans1, ans2);
    }

    public int minNumber2(int[] nums1, int[] nums2) {
        // Initialize bit masks for both arrays to track the numbers present
        int maskNums1 = 0, maskNums2 = 0;

        // Iterate through nums1 and set corresponding bits in the mask for nums1
        for (int num : nums1) {
            maskNums1 |= 1 << num;
        }

        // Iterate through nums2 and set corresponding bits in the mask for nums2
        for (int num : nums2) {
            maskNums2 |= 1 << num;
        }

        // Calculate the bitwise AND of both masks to find common numbers
        int commonMask = maskNums1 & maskNums2;

        // If there is a common number, return the smallest one
        if (commonMask != 0) {
            return Integer.numberOfTrailingZeros(commonMask);
        }

        // If there are no common numbers, find the smallest numbers in each array
        int smallestNums1 = Integer.numberOfTrailingZeros(maskNums1);
        int smallestNums2 = Integer.numberOfTrailingZeros(maskNums2);

        // Calculate the minimum number by concatenating the smallest numbers from both arrays
        // in both possible orders and return the smallest result
        return Math.min(smallestNums1 * 10 + smallestNums2, smallestNums2 * 10 + smallestNums1);
    }

    public static void main(String[] args) {

        L2605_Form_Smallest_Number_From_Two_Digit_Arrays s = new L2605_Form_Smallest_Number_From_Two_Digit_Arrays();
        long sysDate1 = System.currentTimeMillis();

        int nums1[] = {4, 1, 3};
        int nums2[] = {5, 7};
        int res = s.minNumber(nums1, nums2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}