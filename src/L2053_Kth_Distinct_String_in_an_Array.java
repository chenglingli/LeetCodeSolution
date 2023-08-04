import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L2053_Kth_Distinct_String_in_an_Array {


    /*
    1 <= k <= arr.length <= 1000
    1 <= arr[i].length <= 5
    arr[i] consists of lowercase English letters.
     */
    public String kthDistinct(String[] arr, int k) {

        List<String> strList = new ArrayList<>();
        List<String> duplicateList = new ArrayList<>();

        for (String s : arr) {
            if (!duplicateList.contains(s)) {
                if (strList.contains(s)) {
                    strList.remove(s);
                    duplicateList.add(s);
                } else {
                    strList.add(s);
                }
            }
        }

        if (k > strList.size()) {
            return "";
        } else {
            return strList.get(k - 1);
        }
    }


    public String kthDistinct2(String[] arr, int k) {

        Set<String> setDuplicates = new HashSet<>();
        Set<String> setDistinct = new HashSet<>();

        for (String s : arr) {
            if (!setDuplicates.contains(s)) {
                if (setDistinct.contains(s)) {
                    setDistinct.remove(s);
                    setDuplicates.add(s);
                } else {
                    setDistinct.add(s);
                }
            }
        }

        for (String s : arr) {
            if (setDistinct.contains(s))
                k--;
            if (k == 0)
                return s;
        }

        return "";
    }

    public static void main(String[] args) {

        L2053_Kth_Distinct_String_in_an_Array s = new L2053_Kth_Distinct_String_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        String res = s.kthDistinct2(arr, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}