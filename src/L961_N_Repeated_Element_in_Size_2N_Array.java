import java.util.HashMap;
import java.util.Map;

public class L961_N_Repeated_Element_in_Size_2N_Array {

    public int repeatedNTimes(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0 ; i < nums.length; i++) {
            int cur = nums[i];
            if (countMap.containsKey(cur)) {
                countMap.put(cur, countMap.get(cur) + 1);
            }
            else {
                countMap.put(cur, 1);
            }

            if (countMap.get(cur) == nums.length/2) {
                return cur;
            }
        }

        return 0;
    }

    /*
        因为是 2n长度，n+1 唯一的数字，所以n+1数字的间隔必然不可以隔开很多，最多隔一个
     */
    public int repeatedNTimes2(int[] nums) {

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[i - 2]) {
                return nums[i];
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {

        L961_N_Repeated_Element_in_Size_2N_Array s = new L961_N_Repeated_Element_in_Size_2N_Array();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3, 4, 3, 3};

        int res = s.repeatedNTimes(input);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}