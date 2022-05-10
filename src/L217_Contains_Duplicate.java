import java.util.HashSet;

public class L217_Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }

    public static void main(String[] args) {

        L217_Contains_Duplicate s = new L217_Contains_Duplicate();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 1};
        boolean res = s.containsDuplicate(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}