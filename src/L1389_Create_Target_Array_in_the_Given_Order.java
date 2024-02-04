import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1389_Create_Target_Array_in_the_Given_Order {


    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int in = index[i];
            res.add(in, cur);
        }

        int[] resValue = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            resValue[i] = res.get(i);
        }
        return resValue;
    }

    public static void main(String[] args) {

        L1389_Create_Target_Array_in_the_Given_Order s = new L1389_Create_Target_Array_in_the_Given_Order();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 0};
        int[] index = {0, 1, 2, 3, 0};

        int[] res = s.createTargetArray(nums, index);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}