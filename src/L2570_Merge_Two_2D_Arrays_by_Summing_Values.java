import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2570_Merge_Two_2D_Arrays_by_Summing_Values {

    /*
    You are given two 2D integer arrays nums1 and nums2.

    nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
    nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
    Each array contains unique ids and is sorted in ascending order by id.

    Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

    Only ids that appear in at least one of the two arrays should be included in the resulting array.
    Each id should be included only once and its value should be the sum of the values of this id in the two arrays.
    If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
    Return the resulting array. The returned array must be sorted in ascending order by id.



    Example 1:
    Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
    Output: [[1,6],[2,3],[3,2],[4,6]]
    Explanation: The resulting array contains the following:
    - id = 1, the value of this id is 2 + 4 = 6.
    - id = 2, the value of this id is 3.
    - id = 3, the value of this id is 2.
    - id = 4, the value of this id is 5 + 1 = 6.


    Example 2:
    Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
    Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
    Explanation: There are no common ids, so we just include each id with its value in the resulting list.


    Constraints:

    1 <= nums1.length, nums2.length <= 200
    nums1[i].length == nums2[j].length == 2
    1 <= idi, vali <= 1000
    Both arrays contain unique ids.
    Both arrays are in strictly ascending order by id.

     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] ids = new int[1001];
        for (int[] num : nums1) {
            ids[num[0]] += num[1];
        }
        for (int[] num : nums2) {
            ids[num[0]] += num[1];
        }

        int count = 0;
        for (int id : ids) {
            if (id != 0) {
                count++;
            }
        }

        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] != 0) {
                result[index++] = new int[]{i, ids[i]};
            }
        }

        return result;
    }

    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {

        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while(i < m && j < n){
            if(nums1[i][0] == nums2[j][0]){
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++; j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                result.add(nums1[i]);
                i++;
            }
            else{
                result.add(nums2[j]);
                j++;
            }
        }

        while(i < m){
            result.add(nums1[i]);
            i++;
        }
        while(j < n){
            result.add(nums2[j]);
            j++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        L2570_Merge_Two_2D_Arrays_by_Summing_Values s = new L2570_Merge_Two_2D_Arrays_by_Summing_Values();
        long sysDate1 = System.currentTimeMillis();

        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        int[][] res = s.mergeArrays(nums1, nums2);
        System.out.println(Arrays.deepToString(res));


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}