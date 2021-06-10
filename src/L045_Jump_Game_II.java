public class L045_Jump_Game_II {


    /**
     * 动态规划做法
     *
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int[] jumpCount = new int[100000];

        for (int i = 0; i < len; i++) {
            int step = nums[i];
            int count = jumpCount[i] + 1;
            updateCount(count, jumpCount, step, i);
        }
        return jumpCount[len - 1];
    }

    private void updateCount(int count, int[] jumpCount, int step, int start) {
        for (int i = 1; i <= step; i++) {
            if (jumpCount[start + i] > count || jumpCount[start + i] == 0) {
                jumpCount[start + i] = count;
            }
        }
    }

    /**
     * 爬楼梯模式
     *
     * We use "last" to keep track of the maximum distance that has been reached
     * by using the minimum steps "ret", whereas "curr" is the maximum distance
     * that can be reached by using "ret+1" steps. Thus,
     * curr = max(i+A[i]) where 0 <= i <= last.
     *
     * last 当前ret可达最远
     * curr，ret+1可达最远
     * ret 步数
     *
     */
    public int jump2(int[] nums) {

        int len = nums.length;

        int ret = 0;
        int last = 0;
        int cur = 0;

        for (int i = 0; i < len; i++) {
            // 需要进行下次跳跃，则更新last和当执行的跳数ret
            if (i > last) {
                last = cur;
                ++ret;
            }
            // 记录当前可达的最远点
            cur = Math.max(cur, i+nums[i]);

            if (last >= len) {
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        L045_Jump_Game_II s = new L045_Jump_Game_II();

        long sysDate1 = System.currentTimeMillis();

        int input[] = {2, 1};

        int res = s.jump2(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}