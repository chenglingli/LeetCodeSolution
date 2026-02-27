import java.util.Arrays;

public class L3769_Sort_Integers_by_Binary_Reflection {

    /*
    You are given an integer array nums.

    The binary reflection of a positive integer is defined as the number obtained by reversing the order of its binary digits
    (ignoring any leading zeros)
    and interpreting the resulting binary number as a decimal.

    Sort the array in ascending order based on the binary reflection of each element.
    If two different numbers have the same binary reflection, the smaller original number should appear first.

    Return the resulting sorted array.



    Example 1:

    Input: nums = [4,5,4]

    Output: [4,4,5]

    Explanation:

    Binary reflections are:

    4 -> (binary) 100 -> (reversed) 001 -> 1
    5 -> (binary) 101 -> (reversed) 101 -> 5
    4 -> (binary) 100 -> (reversed) 001 -> 1
    Sorting by the reflected values gives [4, 4, 5].


    Example 2:

    Input: nums = [3,6,5,8]

    Output: [8,3,6,5]

    Explanation:

    Binary reflections are:

    3 -> (binary) 11 -> (reversed) 11 -> 3
    6 -> (binary) 110 -> (reversed) 011 -> 3
    5 -> (binary) 101 -> (reversed) 101 -> 5
    8 -> (binary) 1000 -> (reversed) 0001 -> 1
    Sorting by the reflected values gives [8, 3, 6, 5].
    Note that 3 and 6 have the same reflection, so we arrange them in increasing order of original value.


    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 10^9

     */
    public int[] sortByReflection(int[] nums) {
        NUM[] nums2 = new NUM[nums.length];

        for (int i = 0; i < nums.length; i++) {
            String binary = Integer.toBinaryString(nums[i]);
            StringBuilder sb = new StringBuilder();
            sb.append(binary);
            sb.reverse();
            int reflection = Integer.parseInt(sb.toString(), 2);
            nums2[i] = new NUM(nums[i], reflection);
        }

        Arrays.sort(nums2, (a, b) -> a.reflection == b.reflection ? a.num - b.num : a.reflection - b.reflection);

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums2[i].num;
        }

        return res;
    }

    class NUM {
        int num;
        int reflection;

        NUM(int n, int r) {
            num = n;
            reflection = r;
        }
    }


    private int binaryReflection(int n) {
        int res = 0;
        while (n > 0) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }

    public int[] sortByReflection2(int[] nums) {

        // 创建Long数组用于排序
        final Long[] box = new Long[nums.length];

        // 将二进制反射值和原值组合成64位整数
        for (int i = 0; i < nums.length; ++i) {
            box[i] = ((long) binaryReflection(nums[i]) << 32) | nums[i];
        }

        // 按二进制反射值排序
        Arrays.sort(box);

        // 提取排序后的原值
        for (int i = 0; i < nums.length; ++i) {
            final long v = box[i];
            nums[i] = (int) v;
        }

        return nums;
    }

    public static void main(String[] args) {

        L3769_Sort_Integers_by_Binary_Reflection s = new L3769_Sort_Integers_by_Binary_Reflection();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 6, 5, 8};
        int[] res = s.sortByReflection(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}