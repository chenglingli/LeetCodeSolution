import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class L220_Contains_Duplicate_III {

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

        if (nums.length == 0 || k == 0 || t < 0) {
            return false;
        }

        int left = 0;
        int right = -1;
        TreeMap<Long, Integer> treeMap = new TreeMap<>();

        while (left < nums.length) {
            if (right + 1 < nums.length && right - left < k) {
                right++;

                Long newNum = (long) nums[right];
                if (treeMap.ceilingEntry(-(long) t + newNum) != null) {
                    Map.Entry<Long, Integer> ceil = treeMap.ceilingEntry(-(long) t + newNum);
                    if (ceil.getKey() <= (long) t + newNum) {
                        return true;
                    }
                }

                if (treeMap.containsKey(newNum)) {
                    treeMap.put(newNum, treeMap.get(newNum) + 1);
                } else {
                    treeMap.put(newNum, 1);
                }
            } else {
                treeMap.put((long) nums[left], treeMap.get((long) nums[left] - 1));
                if (treeMap.get((long) nums[left]) == null || treeMap.get((long) nums[left]) == 0) {
                    treeMap.remove((long) nums[left]);
                }
                left++;
            }
        }

        return false;
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums.length == 0 || k == 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // initially we fill the tree set (red black tree) with first k numbers
            // after k characters we need to delete the first number, because we move the window
            // according the requirements |i-j| <= k

            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            // if tree has already such number, recall |a-b| <= k, here a=a, logically we get difference zero
            if (set.contains(nums[i])) {
                return true;
            }

            if (t > 0) {
                // we need to find the max from the smallest number so that difference <= k
                // also include the case when the number could be negative or bigger
                Integer lowerKey = set.lower(nums[i]);

                Integer higherKey = set.higher(nums[i]);
                if ((lowerKey != null && Math.abs((long) lowerKey - nums[i]) <= t) ||
                        (higherKey != null && Math.abs((long) higherKey - nums[i]) <= t)) {
                    return true;
                }
            }
            set.add(nums[i]);
        }

        return false;

    }


    public static void main(String[] args) {

        L220_Contains_Duplicate_III s = new L220_Contains_Duplicate_III();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 5, 9, 1, 5, 9};
        boolean res = s.containsNearbyAlmostDuplicate(input, 2, 3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}