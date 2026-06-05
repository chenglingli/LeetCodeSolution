import java.util.*;

public class L1282_Group_the_People_Given_the_Group_Size_They_Belong_To {

    /*

    There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.

    You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
    For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.

    Return a list of groups such that each person i is in a group of size groupSizes[i].

    Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers,
    return any of them. It is guaranteed that there will be at least one valid solution for the given input.



    Example 1:

    Input: groupSizes = [3,3,3,3,3,1,3]
    Output: [[5],[0,1,2],[3,4,6]]
    Explanation:
    The first group is [5]. The size is 1, and groupSizes[5] = 1.
    The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
    The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
    Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
    Example 2:

    Input: groupSizes = [2,1,3,3,3,2]
    Output: [[1],[0,5],[2,3,4]]


    Constraints:

    groupSizes.length == n
    1 <= n <= 500
    1 <= groupSizes[i] <= n

     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new LinkedList<>());
            }
            map.get(groupSizes[i]).add(i);
            if (map.get(groupSizes[i]).size() == groupSizes[i]) {
                res.add(new ArrayList<>(map.get(groupSizes[i])));
                map.get(groupSizes[i]).clear();
            }
        }

        return res;
    }

    /**
     * 方法2，更为高效
     * 思路：
     * 用一个数组记录每个组的大小，然后遍历这个数组，每次找到一个大小为k的组，就将这k个元素放到答案中。
     * 用一个数组记录每个元素是否已经被分配到某个组中，如果已经被分配了，则不再考虑。
     * 时间复杂度：O(n)，其中 n 是数组 groupSizes 的长度。
     */
    public List<List<Integer>> groupThePeople2(int[] grp) {

        int n = grp.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (grp[i] == 0) {
                continue;
            }

            List<Integer> list = new ArrayList<>();
            list.add(i);
            int size = grp[i] - 1;

            int j = i + 1;
            while (j < n && size > 0) {
                if (grp[j] == grp[i]) {
                    grp[j] = 0;
                    list.add(j);
                    size--;
                }
                j++;
            }
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {

        L1282_Group_the_People_Given_the_Group_Size_They_Belong_To s = new L1282_Group_the_People_Given_the_Group_Size_They_Belong_To();
        long sysDate1 = System.currentTimeMillis();

        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> res = s.groupThePeople(groupSizes);
        System.out.println(res.toString());

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}