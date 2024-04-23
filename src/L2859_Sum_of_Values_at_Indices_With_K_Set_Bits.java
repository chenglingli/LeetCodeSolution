import java.util.ArrayList;
import java.util.List;

public class L2859_Sum_of_Values_at_Indices_With_K_Set_Bits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int n = nums.size();
        int res = 0;

        for (int i = 0; i < n; i++)
            if (Integer.bitCount(i) == k)
                res += nums.get(i);

        return res;
    }

    public static void main(String[] args) {

        L2859_Sum_of_Values_at_Indices_With_K_Set_Bits s = new L2859_Sum_of_Values_at_Indices_With_K_Set_Bits();
        long sysDate1 = System.currentTimeMillis();


        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(10);
        nums.add(1);
        nums.add(5);
        nums.add(2);
        int k = 1;

        int res = s.sumIndicesWithKSetBits(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}