public class L055_Jump_Game {

    /**
     * 贪心做法
     */
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int reachableIndex = 0;

        for (int i = 0; i < len ; i++) {
            if (i > reachableIndex || reachableIndex >= len - 1) {
                break;
            }
            if (nums[i] + i > reachableIndex) {
                reachableIndex = nums[i] + i;
            }
        }
        return reachableIndex >= len - 1;
    }

    /**
     * 动态规划做法
     * jumpPower[i] 表示到第i个坐标，还剩余的跳力。
     * 某个坐标是否可达，则可以从剩余跳力是否>=0 可以得出结论
     *
     * jumpPower[i] = max {jumpPower[i-1], num[i-1]} - 1
     * 因为每一位坐标都由前面坐标跳转而来，所以 i-1位置的剩余跳力-1 和 i-1位置的初始跳力-1 可作为当前位置跳力。
     *
     */
    public boolean canJump2(int[] nums) {

        int len = nums.length;
        int[] jumpPower = new int[10000];

        for (int i = 1; i < len; i++) {
            jumpPower[i] = Math.max(jumpPower[i - 1], nums[i - 1])- 1;
            if (jumpPower[i] < 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        L055_Jump_Game s = new L055_Jump_Game();

        long sysDate1 = System.currentTimeMillis();

        int input[] = {3,2,1,0,4};

        boolean res = s.canJump2(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}