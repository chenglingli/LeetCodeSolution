import java.util.*;

public class L599_Minimum_Index_Sum_of_Two_Lists {

    /*
    1 <= list1.length, list2.length <= 1000
    1 <= list1[i].length, list2[i].length <= 30

    list1[i] and list2[i] consist of spaces ' ' and English letters.
    All the strings of list1 are unique.
    All the strings of list2 are unique.
    There is at least a common string between list1 and list2.

     */
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> StringCount = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            StringCount.put(list1[i], (i + 1) * (-1));
        }

        for (int i = 0; i < list2.length; i++) {
            if (StringCount.containsKey(list2[i])) {
                StringCount.put(list2[i], StringCount.get(list2[i]) * (-1) + (i + 1));
            }
        }

        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (String k : StringCount.keySet()) {
            if (StringCount.get(k) < 0) {
                continue;
            }
            if (StringCount.get(k) < min) {
                min = StringCount.get(k);
                res.clear();
                res.add(k);
            } else if (StringCount.get(k) == min) {
                res.add(k);
            }
        }

        return res.toArray(new String[0]);
    }

    /*
    精妙之处在于其利用list的塞入和计数器做到只要取前几个即可
     */
    public String[] findRestaurant2(String[] list1, String[] list2) {

        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hm.put(list1[i], i);
        }

        int count = 0;
        int minval = Integer.MAX_VALUE;

        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length && i <= minval; i++) {
            Integer x = hm.get(list2[i]);
            if (x != null) {
                if (minval > x + i) {
                    res.add(0, list2[i]);
                    minval = x + i;
                    count = 1;
                } else if (minval == x + i) {
                    res.add(count++, list2[i]);
                }
            }
        }

        return res.subList(0, count).toArray(new String[0]);
    }

    public static void main(String[] args) {

        L599_Minimum_Index_Sum_of_Two_Lists s = new L599_Minimum_Index_Sum_of_Two_Lists();

        long sysDate1 = System.currentTimeMillis();

        //        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        //        String[] list2 = {"KFC", "Shogun", "Burger King"};

        String[] list1 = {"happy", "sad", "good"};
        String[] list2 = {"sad", "happy", "good"};

        String[] res = s.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}