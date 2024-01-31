import java.util.HashMap;
import java.util.HashSet;

public class L403_Frog_Jump {


    /*
    2 <= stones.length <= 2000
    0 <= stones[i] <= 2^31 - 1
    stones[0] == 0
    stones is sorted in a strictly increasing order.

    bool f[i][k] 表示第i个石头可达，用的k步

    那么 f[i][k] = f[j][k-1] || f[j][k] || f[j][k+1] (j < i)
    即：是否存在一个j，跳转k-1，k或k+1步能到 i点

     */
    public boolean canCross(int[] stones) {

        int n = stones.length;
        boolean[][] f = new boolean[n][n];
        f[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {

                int k = stones[i] - stones[j];

                // 每次跳转最大距离就是j
                // 第1次跳1，第2次跳2，第3次跳3，可见最大跳跃距离是递增的且为n
                if (k > j + 1) {
                    break;
                }

                f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];

                if (i == n - 1 && f[i][k]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canCross2(int[] stones) {
        // If distance from stones[0] to stones[1] is not exactly 1, then
        // frog cannot cross the river, because the problem requires the
        // first jump distance starting at stones[0] be k=1.  After this,
        // the code will ignore stones[0], and start everything from
        // stones[1].
        if (stones[1] - stones[0] != 1) return false;

        // Nuber of stones in the stones[] array.
        int stonesCount = stones.length;
        // Absolute start position for starting at stones[1].  All other
        // stones positions will be converted to a relative position from
        // stones[1].
        int stonesBase = stones[1];
        // Determine the worst-case farthest position the frog can try to
        // jump.  The first farthest position uses a worst case where the
        // jumps are 1,2,3,4,...n-2,n-1,n, where n is the number of stones.
        // Adding all these jumps together will give the sum of the first
        // n integers, or by formula: (n*(n-1))/2.
        int stonesFarthest = (stonesCount * (stonesCount + 1)) / 2;
        // If the distance between the last stone and the starting stone[1]
        // is greater than the farthest distance the frong can try to jump,
        // then the last stone is beyond the frog's range, so the frog fails.
        if (stones[stonesCount - 1] - stonesBase > stonesFarthest)
            return false;
        // Further limit the farthest position the frog can try to jump.
        // This is done AFTER the 'if' statement above, to prevent the
        // calculation from overflowing an int value, since the max stone
        // position is 2**31-1, and stones[1] has a minimum value of 1.
        // The farthest the frog can try to jump is the relative position of
        // the last stone, plus the max value of k when reaching the last
        // stone, at which position largest possible k will have a max
        // value of the number of stones.
        stonesFarthest = Math.min(stonesFarthest,
                stones[stonesCount - 1] - stonesBase + stonesCount);

        // Create the boolean array of stones, indexed by relative position
        // across the river, and containing true if a stone exists at that
        // relative position.  The absolute stone positions in the passed
        // stones[] array, will be converted to positions relative to the
        // starting stone at position stones[1].  In the boolean stonesArr[]
        // array, stones[1] will be at relative position 0, so stonesArr[0]
        // will be true to indicate stones[1] exists at stonesArr[0].  The
        // passed stones[] array is indexed by stone number and contains each
        // stones' absolute position.  The stonesArr[] array is indexed by
        // relative position, and contains true if a stone exists at thst
        // relative position, or contains false if no stone exists at that
        // relative position.
        boolean[] stonesArr = new boolean[stonesFarthest + 1];
        // Convert stones from the stones[] array of absolute stone positions,
        // to the stonesArr[] boolean array.
        for (int i = stones.length - 1; i > 0; i--)
            stonesArr[stones[i] - stonesBase] = true;

        // Do the recursive depth-first-search for the frogs having a jump
        // path from the first stone (stones[1] at relative position 0) to the
        // last stone (stones[stones.length - 1]) at its position relative to
        // the position of stones[1].
        return dfs(0, 1, stonesArr, new HashSet<Long>(),
                stones[stonesCount - 1] - stonesBase);
    }


    // Recursive depth-first-search for a jump path to the last stone.  Within
    // this routine, the values from the stones[] array are no longer needed,
    // because the stonesArr[] boolean array indexed by relative position across
    // the river is easier for checking if a next stone to jump to actually exists.
    // Inputs:
    //      pos             Relative position across the river, of current stone.
    //                      Relative positions are relative to first stone stones[1].
    //      k               Distance of previous jump.
    //      stonesArr[]     Boolean array indexed by relative position, with a
    //                      value of true indicating if a stone exists at that
    //                      relative position.
    //      failedSet       Memorization data to indicate a stone with a specific
    //                      k value, does NOT have a path to the last stone.
    //                      Implemented as a HashSet referenced by a stone's
    //                      relative position combined with a specific.  If that stone
    //                      and k value exist in the set, then a path from that stone
    //                      to the last stone does NOT exist.
    //      lastStonePos    The relative position of the last stone, which is the
    //                      end-point for the frog's journey across the river.
    //                      I don't know why the frog has to stay dry on the stones,
    //                      then stop at the last stone, instead of swimming all
    //                      the way across the river.
    private boolean dfs(
            int pos, int k, boolean[] stonesArr,
            HashSet<Long> failedSet, int lastStonePos) {
        // If at the last stone, then the frog's journey is complete.
        if (pos == lastStonePos) return true;
        // If memorized that no valid path from current stone to the end, then
        // immediately return, reporting failure.
        if (failedSet.contains((long) pos * 10_000 + k)) return false;
        // If stone exists k+1 positions ahead, then recurse to try to find a path
        // to the final stone.  Then try k stones ahead.  Then k-1 stones ahead.
        if (stonesArr[pos + k + 1])
            if (dfs(pos + k + 1, k + 1, stonesArr, failedSet, lastStonePos)) return true;
        if (stonesArr[pos + k])
            if (dfs(pos + k, k, stonesArr, failedSet, lastStonePos)) return true;
        if (k > 1 && stonesArr[pos + k - 1])
            if (dfs(pos + k - 1, k - 1, stonesArr, failedSet, lastStonePos)) return true;
        // Failed to find a path from the current stone to the last stone with the
        // given value of k.  Memorize this failure, then return reporting the failure.
        failedSet.add((long) pos * 10_000 + k);
        return false;
    }

    public boolean canCross3(int[] stones) {
        HashMap<Integer, Boolean> map = new HashMap<>(); // 构建空map
        return helper(stones, 0, 0, map); // 上一步跳了0步，现在在索引0处，基于此，能否到终点
    }

    private boolean helper(int[] stones, int index, int k, HashMap<Integer, Boolean> map) {

        int tempKey = index * 1000 + k; // 构造唯一的key，代表当前子问题
        int len = stones.length;

        if (map.containsKey(tempKey)) { // 这个子问题之前遇到过，直接返回false
            return false;
        } else { // 第一次遇到这个子问题，在map记录一下
            map.put(tempKey, true);
        }

        for (int i = index + 1; i < len; i++) {
            int gap = stones[i] - stones[index]; // 本轮迭代选择跳到i，算出第i石头到当前石头的距离
            if (gap >= k - 1 && gap <= k + 1) { // 这一步能跳[k-1, k+1]步
                if (helper(stones, i, gap, map)) { // 基于第i石头，跳了gap步，能否到达终点
                    return true;
                }
            } else if (gap > k + 1) { // 因为石头是有序的，所以如果gap>k+1，那么后面的石头就不用看了
                break;
            } // 这是gap<k-1的情况，说明这个点离太近了，要继续下一轮迭代，看看远一点的石头
        }

        return index == len - 1; // 遍历完所有选择，都不能到达终点，返回false
    }

    public static void main(String[] args) {

        L403_Frog_Jump s = new L403_Frog_Jump();

        long sysDate1 = System.currentTimeMillis();

        int[] stones = {0, 1, 2, 4, 7, 9, 10, 12, 13, 14, 16, 17, 19, 22, 24};
        //        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};

        boolean res = s.canCross3(stones);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}