import java.util.ArrayList;
import java.util.List;

public class L1560_Most_Visited_Sector_in_a_Circular_Track {


    /*
    Given an integer n and an integer array rounds.
    We have a circular track which consists of n sectors labeled from 1 to n. A marathon will be held on this track,
    the marathon consists of m rounds.

    The ith round starts at sector rounds[i - 1] and ends at sector rounds[i].
    For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]

    Return an array of the most visited sectors sorted in ascending order.

    Notice that you circulate the track in ascending order of sector numbers in the counter-clockwise direction
        (See the first example).



    Example 1:
    Input: n = 4, rounds = [1,3,1,2]
    Output: [1,2]
    Explanation: The marathon starts at sector 1. The order of the visited sectors is as follows:
    1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of round 3 and the marathon)
    We can see that both sectors 1 and 2 are visited twice and they are the most visited sectors.
    Sectors 3 and 4 are visited only once.

    Example 2:
    Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
    Output: [2]

    Example 3:
    Input: n = 7, rounds = [1,3,5,7]
    Output: [1,2,3,4,5,6,7]


    Constraints:

    2 <= n <= 100
    1 <= m <= 100
    rounds.length == m + 1
    1 <= rounds[i] <= n
    rounds[i] != rounds[i + 1] for 0 <= i < m

     */
    public List<Integer> mostVisited(int n, int[] rounds) {

        /*

        本题大意：
        给定一个整数n和一个整数数组rounds。
        我们有一个圆形轨道，由1到n的标签组成。
        马拉松将在该轨道上举行，马拉松包括m轮。
        第i轮从rounds[i-1]扇区开始，在rounds[i]扇区结束。
        返回按升序排序的最常访问扇区的数组。

         */


        // 解法：
        // 1. 找出起始点和终点
        // 2. 如果起始点小于等于终点，则从起始点到终点依次加入结果集；否则，先从1到终点加入结果集，再从起始点到n加入结果集。
        // 3. 返回结果集。

        List<Integer> Result = new ArrayList<>();

        int start = rounds[0];
        int end = rounds[rounds.length - 1];

        if (start <= end) {
            for (int i = start; i <= end; i++)
                Result.add(i);
        } else {
            for (int i = 1; i <= end; i++)
                Result.add(i);
            for (int i = start; i <= n; i++)
                Result.add(i);
        }

        return Result;
    }

    public static void main(String[] args) {

        L1560_Most_Visited_Sector_in_a_Circular_Track s =
                new L1560_Most_Visited_Sector_in_a_Circular_Track();
        long sysDate1 = System.currentTimeMillis();

        int n = 4;
        int []rounds = {1, 3, 1, 2};
        List<Integer> res = s.mostVisited(n, rounds);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}