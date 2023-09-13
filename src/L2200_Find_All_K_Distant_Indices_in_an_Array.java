import java.util.ArrayList;
import java.util.List;

public class L2200_Find_All_K_Distant_Indices_in_an_Array {

    /*
    1 <= nums.length <= 1000
    1 <= nums[i] <= 1000
    key is an integer from the array nums.
    1 <= k <= nums.length
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> res = new ArrayList<>();
        int[] mark = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                addIntoMark(mark, Math.max(i - k, 0), Math.min(i + k, nums.length - 1));
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (mark[i] == 1) {
                res.add(i);
            }
        }

        return res;
    }

    private void addIntoMark(int[] mark, int i, int j) {
        for (int x = i; x <= j; x++) {
            mark[x] = 1;
        }
    }


    public List<Integer> findKDistantIndices2(int[] nums, int key, int k) {

        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        int p1 = 0;
        int p2 = 0;

        while (p1 < len && p2 < len) {

            // 寻找下一个key的index，记录为p2
            while (p2 < len && nums[p2] != key) {
                p2++;
            }

            // 到尾部，结束
            if (p2 == len) break;

            // 确定需要加入的范围，[left，right]
            int left = Math.max(0, p2 - k);
            int right = Math.min(p2 + k, len - 1);

            // 范围内index加入到res
            while (p1 <= right) {
                if (p1 >= left) {
                    res.add(p1);
                }

                p1++;
            }

            // 继续向前看
            p2++;
        }

        return res;
    }

    public static void main(String[] args) {

        L2200_Find_All_K_Distant_Indices_in_an_Array s =
                new L2200_Find_All_K_Distant_Indices_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        //        int key = 9;
        //        int k = 1;

        int[] nums = {2, 2, 2, 2, 2, 2};
        int key = 2;
        int k = 2;

        List<Integer> res = s.findKDistantIndices(nums, key, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}