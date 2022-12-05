import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L1122_Relative_Sort_Array {


    /*

    Given two arrays arr1 and arr2,
        the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

    Sort the elements of arr1 such that
        the relative ordering of items in arr1 are the same as in arr2.
    Elements that do not appear in arr2
        should be placed at the end of arr1 in ascending order.

    Example 1:

    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    Output: [2,2,2,1,4,3,3,9,6,7,19]

    Example 2:

    Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
    Output: [22,28,8,6,17,44]
     */


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[arr2.length];

        List<Integer> arr2List = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        List<Integer> remain = new ArrayList<>();

        for (int cur : arr1) {
            int index = arr2List.indexOf(cur);
            if (index != -1) {
                count[index] += 1;
            } else {
                remain.add(cur);
            }
        }

        Collections.sort(remain);

        int[] res = new int[arr1.length];
        int i = 0;
        int c = 0;
        for (Integer x : arr2) {
            int curCount = count[c];
            for (int j = 0; j < curCount; j++) {
                res[i++] = x;
            }
            c++;
        }
        for (Integer x : remain) {
            res[i++] = x;
        }

        return res;
    }

    // 有点桶排序感觉
    //
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {

        int[] cnt = new int[1001];

        for (int n : arr1)
            cnt[n]++;

        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }

        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {

        L1122_Relative_Sort_Array s = new L1122_Relative_Sort_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        int[] res = s.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}