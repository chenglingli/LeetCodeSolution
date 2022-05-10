import java.util.HashMap;

public class L219_Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length == 0 || k == 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            Integer x = map.get(nums[i]);
            if (x == null) {
                map.put(nums[i], i);
            } else {
                if (i - x <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        L219_Contains_Duplicate_II s = new L219_Contains_Duplicate_II();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3, 1, 2, 3};
        boolean res = s.containsNearbyDuplicate(input, 2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}