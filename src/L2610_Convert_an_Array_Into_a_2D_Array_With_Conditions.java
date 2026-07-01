import java.util.ArrayList;
import java.util.List;

public class L2610_Convert_an_Array_Into_a_2D_Array_With_Conditions {

    /*
    You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

    The 2D array should contain only the elements of the array nums.
    Each row in the 2D array contains distinct integers.
    The number of rows in the 2D array should be minimal.
    Return the resulting array. If there are multiple answers, return any of them.

    Note that the 2D array can have a different number of elements on each row.


    Example 1:

    Input: nums = [1,3,4,1,2,3,1]
    Output: [[1,3,4,2],[1,3],[1]]
    Explanation: We can create a 2D array that contains the following rows:
    - 1,3,4,2
    - 1,3
    - 1
    All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
    It can be shown that we cannot have less than 3 rows in a valid array.
    Example 2:

    Input: nums = [1,2,3,4]
    Output: [[4,3,2,1]]
    Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.


    Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= nums.length
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int distinctCount = 0;
        int[] count = new int[201];
        for (int num : nums) {
            if (count[num] == 0) distinctCount++;
            count[num]++;
        }

        while (distinctCount > 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i < count.length; i++) {
                if (count[i] > 0) {
                    temp.add(i);
                    count[i]--;
                    if (count[i] == 0) {
                        distinctCount--;
                    }
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    public List<List<Integer>> findMatrix2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // the goal is to create 2d so that the number of rows is minimal and
        // each row has a distinct integer

        // the idea is to have the first occurrence of a number in 1st row, second in second row

        int[] freq = new int[nums.length + 1]; // coz the numbers start from 1, so we need 1 to n+1

        for (int num : nums) {
            // create. a new row when the freq of the number is >= size of the list,
            // i.e. for the freq which is to be the row index we need new row as it does not exist by then, ans.size() is the row index
            if (freq[num] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            // add the number to the row == the number's index
            // 把number放到对应的行，即num对应count就算是index
            // 譬如，1出现2次，2出现1次，则第一个1放在第一行，第二个1放在第二行

            ans.get(freq[num]).add(num);
            freq[num]++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2610_Convert_an_Array_Into_a_2D_Array_With_Conditions s = new L2610_Convert_an_Array_Into_a_2D_Array_With_Conditions();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> res = s.findMatrix(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}