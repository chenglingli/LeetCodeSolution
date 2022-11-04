public class L997_Find_the_Town_Judge {


    // 查找那个只有入度没有出度的节点
    public int findJudge(int n, int[][] trust) {

        // 被信任计数器
        int[] trustedCount = new int[n + 1];
        // 是否信任别人标记
        int[] markTrust = new int[n + 1];

        // 计算标记位和count
        for (int[] cur : trust) {
            trustedCount[cur[1]] += 1;
            markTrust[cur[0]] = 1;
        }

        // 查找
        for (int i = 1; i <= n; i++) {
            // 所有人都信任他
            if (trustedCount[i] == n - 1) {
                // 他不信任别人
                if (markTrust[i] == 0) {
                    return i;
                }
            }
        }

        // 未找到
        return -1;
    }

    public static void main(String[] args) {

        L997_Find_the_Town_Judge s = new L997_Find_the_Town_Judge();

        long sysDate1 = System.currentTimeMillis();

        //        int[][] trust = {{1,2}};
        //        int n = 2;

        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int n = 3;

        int res = s.findJudge(n, trust);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}