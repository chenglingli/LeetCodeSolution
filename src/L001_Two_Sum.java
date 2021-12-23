import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Two Sum

public class L001_Two_Sum {

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

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        final int[] result = new int[2];

        for(int i=0; i<nums.length; i++)
        {
            int another = target - nums[i];
            if(m.containsKey(another))
            {
                result[0] = m.get(another);
                result[1] = i;
            }
            else
            {
                m.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        L001_Two_Sum s = new L001_Two_Sum();
        int[] numbers = {2, 7, 11, 15};
        int target = 22;
        int[] res = s.twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }
}

