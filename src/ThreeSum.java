import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums); // {-1,-1,0,1,2,4}
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < length - 2; i = increment(i, nums)) {
            int head = i + 1, tail = length - 1;
            while (head < tail) {
                int temp = nums[head] + nums[tail] + nums[i];
                if (temp < 0) {
                    head = increment(head, nums);
                } else if (temp > 0) {
                    tail = decrease(tail, nums);
                } else {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    head = increment(head, nums);
                }
            }
        }
        return result;
    }

    public int increment (int i, int[] nums) {
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i ++;
        }
        return ++i;
    }

    public int decrease (int i, int[] nums) {
        while (i >= 1 && nums[i] == nums[i - 1]) {
            i --;
        }
        return --i;
    }


    public static void main(String[] args) {

        ThreeSum s = new ThreeSum();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, -8, 0, 2, -5, 4, 3, 7};

        List<List<Integer>> res = s.threeSum(nums);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}