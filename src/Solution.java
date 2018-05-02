/**
 * 去除指定值元素，且需要保持数组前n个值为需要保留值，n个值之后值可以不用care
 *
 * 实现很简单，就是用两个指针指向当前比较值和当前移动值，分别是j和i
 *
 */

public class Solution {


    public int removeElement(int[] nums, int val) {
        int res = 0;

        int i = 0, j = 0;
        while ( j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                if (i != j) {
                    nums[i] = nums[j];
                }
                i++;
                j++;
            }
        }

        return i;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int nums [] = {1, 1};
        int val = 1;

        long sysDate1 = System.currentTimeMillis();

        int res = s.removeElement(nums, val);
        System.out.print("res:");
        System.out.println(res);

        System.out.println("nums:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}