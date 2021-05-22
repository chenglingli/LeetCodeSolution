import java.util.Arrays;

// Two Sum

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
        }

        return result;
    }

    public static void main(String[] args) {

        TwoSum s = new TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int target = 22;
        int[] res = s.twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }
}

