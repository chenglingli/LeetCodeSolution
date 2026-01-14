public class L3678_Smallest_Absent_Positive_Greater_Average {

    /*

    You are given an integer array nums.

    Return the smallest absent positive integer in nums such that it is strictly greater than the average of all elements in nums.

    The average of an array is defined as the sum of all its elements divided by the number of elements.


    Example 1:

    Input: nums = [3,5]

    Output: 6

    Explanation:

    The average of nums is (3 + 5) / 2 = 8 / 2 = 4.
    The smallest absent positive integer greater than 4 is 6.

    Example 2:

    Input: nums = [-1,1,2]

    Output: 3

    Explanation:

    The average of nums is (-1 + 1 + 2) / 3 = 2 / 3 = 0.667.
    The smallest absent positive integer greater than 0.667 is 3.

    Example 3:

    Input: nums = [4,-1]

    Output: 2

    Explanation:

    The average of nums is (4 + (-1)) / 2 = 3 / 2 = 1.50.
    The smallest absent positive integer greater than 1.50 is 2.


    Constraints:

    1 <= nums.length <= 100
    -100 <= nums[i] <= 100
     */
    public int smallestAbsent(int[] nums) {
        int[] exist = new int[101];
        int n = nums.length;
        int sum = 0;

        for (int x : nums) {
            if (x > 0) {
                exist[x] = 1;
            }
            sum += x;
        }

        int start = 1;
        if (sum % n == 0) {
            start = sum / n + 1;
        } else {
            start = (int) Math.ceil(sum * 1.0 / n);
        }

        if (start < 1) {
            for (int i = 1; i <= 100; i++) {
                if (exist[i] == 0) {
                    return i;
                }
            }
            return 100;
        } else {
            int i = start;
            while (i < 101 && exist[i] == 1) {
                i++;
            }
            return i;
        }
    }

    public int smallestAbsent2(int[] nums) {

        boolean[] not_absent = new boolean[201];
        int avg = 0, i;

        for (i = 0; i < nums.length; i++) {
            not_absent[nums[i] + 100] = true;
            avg += nums[i];
        }

        for (i = Math.max(avg / nums.length + 101, 101); i < 201; i++) {
            if (!not_absent[i])
                break;
        }

        return i - 100;
    }


    public static void main(String[] args) {

        L3678_Smallest_Absent_Positive_Greater_Average s = new L3678_Smallest_Absent_Positive_Greater_Average();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {3, 5};
        //        int[] nums1 = {-1, 1, 2};
        int[] nums2 = {4, -1};

        int res = s.smallestAbsent(nums2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}