import java.util.HashMap;

public class L2190_Most_Frequent_Number_Following_Key_In_an_Array {

    /*

    You are given a 0-indexed integer array nums.
    You are also given an integer key, which is present in nums.

    For every unique integer target in nums,
        count the number of times target immediately follows an occurrence of key in nums.

    In other words, count the number of indices i such that:
        0 <= i <= nums.length - 2,
        nums[i] == key and,
        nums[i + 1] == target.

    Return the target with the maximum count.

    The test cases will be generated such that the target with maximum count is unique.

    2 <= nums.length <= 1000
    1 <= nums[i] <= 1000
    The test cases will be generated such that the answer is unique.


    Example 1:
    Input: nums = [1,100,200,1,100], key = 1
    Output: 100
    Explanation:
    For target = 100, there are 2 occurrences at indices 1 and 4 which follow an occurrence of key.
    No other integers follow an occurrence of key, so we return 100.


    Example 2:
    Input: nums = [2,2,2,2,3], key = 2
    Output: 2
    Explanation: For target = 2, there are 3 occurrences at indices 1, 2, and 3 which follow an occurrence of key.
    For target = 3, there is only one occurrence at index 4 which follows an occurrence of key.
    target = 2 has the maximum number of occurrences following an occurrence of key, so we return 2.

     */
    public int mostFrequent(int[] nums, int key) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                int target = nums[i + 1];
                map.put(target, map.getOrDefault(target, 0) + 1);
            }
        }

        int max = 0;
        int re = 0;
        for (int x : map.keySet()) {
            if (map.get(x) > max) {
                re = x;
                max = map.get(x);
            }
        }
        return re;
    }

    public int mostFrequent2(int[] nums, int key) {

        int[] count = new int[1001];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) count[nums[i + 1]]++;
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 1; i <= 1000; i++) {
            if (count[i] > max) {
                max = count[i];
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2190_Most_Frequent_Number_Following_Key_In_an_Array s =
                new L2190_Most_Frequent_Number_Following_Key_In_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 100, 200, 1, 100};
        int key = 1;
        int res = s.mostFrequent2(nums, key);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}