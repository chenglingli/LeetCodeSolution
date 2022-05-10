import java.util.ArrayList;
import java.util.List;

public class L658_Find_K_Closest_Elements {

    /**
     * Given a sorted array, two integers k and x,
     * find the k closest elements to x in the array.
     * The result should also be sorted in ascending order.
     * If there is a tie, the smaller elements are always preferred.
     * <p>
     * Example 1:
     * Input: [1,2,3,4,5], k=4, x=3
     * Output: [1,2,3,4]
     * Example 2:
     * Input: [1,2,3,4,5], k=4, x=-1
     * Output: [1,2,3,4]
     * Note:
     * The value k is positive and will always
     * be smaller than the length of the sorted array.
     * Length of the given array is positive and will not exceed 104
     * Absolute value of elements in the array and x will not exceed 104
     * UPDATE (2017/9/19):
     * The arr parameter had been changed to an array of integers (instead of a list of integers).
     * Please reload the code definition to get the latest changes.
     */

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int i = 0, j = arr.length - 1;
        while (j - i + 1 > k) {
            if (arr[j] - x < x - arr[i]) i++;
            else j--;
        }

        List<Integer> res = new ArrayList<>();
        for (int l = i; l <= j; l++) res.add(arr[l]);

        return res;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {

        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) left = mid + 1;
            else right = mid;
        }

        List<Integer> res = new ArrayList<>();
        for (int l = 0; l < k; l++) {
            res.add(arr[left]);
            left++;
        }

        return res;
    }

    public static void main(String[] args) {

        L658_Find_K_Closest_Elements s = new L658_Find_K_Closest_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] matrix = {1, 2, 3, 4, 5};

        List<Integer> res = s.findClosestElements2(matrix, 4, 3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}