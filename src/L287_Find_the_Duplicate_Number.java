import java.util.Arrays;
import java.util.HashSet;

public class L287_Find_the_Duplicate_Number {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }

        return -1;
    }

    /*
     * Floyd's Tortoise and Hare (Cycle Detection)
     * 环检测算法
     * https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
     *
     * 模拟整体数组成link
     * 分两步，
     * 第一步，龟兔不同速度，跑步，让兔子进到环
     * 第二步，乌龟从外面重新开始，龟兔同速度，计算龟兔交叉点
     *
     */
    public int findDuplicate2(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String[] args) {

        L287_Find_the_Duplicate_Number s = new L287_Find_the_Duplicate_Number();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 2};
        int res = s.findDuplicate(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}