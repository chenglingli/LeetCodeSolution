import java.util.ArrayList;
import java.util.List;

public class L2089_Find_Target_Indices_After_Sorting_Array {

    /*
    1 <= nums.length <= 100
    1 <= nums[i], target <= 100

     */
    public List<Integer> targetIndices(int[] nums, int target) {

        int[] array = new int[101];
        for (int c : nums) array[c]++;
        if (array[target] == 0) return new ArrayList<>();

        int count = 0;
        for (int i = 1; i < target; i++) count += array[i];

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < array[target]; i++) ans.add(count++);

        return ans;
    }

    public static void main(String[] args) {

        L2089_Find_Target_Indices_After_Sorting_Array s = new L2089_Find_Target_Indices_After_Sorting_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 5, 2, 3};
        int target = 1;
        List<Integer> res = s.targetIndices(nums, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}