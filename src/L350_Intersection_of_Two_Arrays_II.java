import java.util.*;

public class L350_Intersection_of_Two_Arrays_II {


    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            if (map.containsKey(j))
                map.put(j, (map.get(j)) + 1);
            else
                map.put(j, 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (map.containsKey(j)) {
                if (map.get(j) > 0) {
                    res.add(j);
                    map.put(j, (map.get(j)) - 1);
                }
            }
        }

        int[] f = new int[res.size()];
        for (int i = 0 ; i < res.size(); i++)
            f[i] = res.get(i);

        return f;
    }


    public static void main(String[] args) {

        L350_Intersection_of_Two_Arrays_II s = new L350_Intersection_of_Two_Arrays_II();
        long sysDate1 = System.currentTimeMillis();

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};

        int[] res2 = s.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res2));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}