import java.util.*;

public class L207_Course_Schedule {

    /*

    There are a total of numCourses courses you have to take,
    labeled from 0 to numCourses - 1. You are given an array
    prerequisites where prerequisites[i] = [ai, bi] indicates that
    you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0
    you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.



    Example 1:

    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0. So it is possible.
    Example 2:

    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0,
    and to take course 0 you should also have finished course 1.
    So it is impossible.

     */

    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        //邻接表，存放的是指向该节点的其他节点编号，而不是边
        //如果某个点没有其他点指向它，那么对应的list为空。
        HashMap<Integer, List<Integer>> map = new HashMap(numCourses);

        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList());

        for (int[] prerequisite : prerequisites) {
            int previous = prerequisite[1];
            int latter = prerequisite[0];

            List<Integer> list = map.get(latter);
            list.add(previous);
        }

        while (map.size() > 0) {
            //判断是否能找到一个没有任何节点指向的节点
            boolean flag = false;
            int num = 0;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
                if (entry.getValue().size() == 0) {
                    flag = true;
                    num = entry.getKey();
                    break;
                }

            if (!flag)
                return false;

            map.remove(num);

            Iterator<List<Integer>> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().remove(new Integer(num));
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L207_Course_Schedule s = new L207_Course_Schedule();

        long sysDate1 = System.currentTimeMillis();

        // int[][] prerequisites = {{1, 0} , {0, 2} , {2, 3}};
        int[][] prerequisites = {{1, 0}};

        boolean res = s.canFinish2(2, prerequisites);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}