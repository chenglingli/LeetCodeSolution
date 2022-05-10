import java.util.*;

public class L208_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //邻接表，存放的是指向该节点的其他节点编号，而不是边
        //如果某个点没有其他点指向它，那么对应的list为空。
        HashMap<Integer, List<Integer>> map = new HashMap(numCourses);

        int[] res = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList());

        for (int[] prerequisite : prerequisites) {
            int previous = prerequisite[1];
            int latter = prerequisite[0];

            List<Integer> list = map.get(latter);
            list.add(previous);
        }

        int i = 0;
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
                return new int[0];

            map.remove(num);
            res[i++] = num;

            Iterator<List<Integer>> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().remove(new Integer(num));
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L208_Course_Schedule_II s = new L208_Course_Schedule_II();

        long sysDate1 = System.currentTimeMillis();

        int[][] prerequisites = {{1, 0}, {0, 2}, {2, 3}};
        // int[][] prerequisites = {{1, 0}, {0, 1}};

        int[] res = s.findOrder(4, prerequisites);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}