import java.util.Arrays;

public class L473_Matchsticks_to_Square {


    /*
    需要排序，且从最大的开始
     */
    public boolean makesquare(int[] matchsticks) {

        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        for (int stick : matchsticks)
            sum = sum + stick;

        if (sum % 4 != 0) {
            return false;
        }
        int oneSideLen = sum / 4;
        int side1 = 0, side2 = 0, side3 = 0, side4 = 0, currIndex = matchsticks.length - 1;

        Arrays.sort(matchsticks);

        return dfs(side1, side2, side3, side4, matchsticks, currIndex, oneSideLen);
    }


    // DFS function to return if len of 4 sides are equal and sum up to total_sum/4 when arr ends.

    public boolean dfs(int s1, int s2, int s3, int s4, int arr[], int k, int len) {

        if (s1 > len || s2 > len || s3 > len || s4 > len) {
            return false;
        }

        if (k == -1) {
            return s1 == s2 && s2 == s3 && s3 == s4;
        }

        // Call recursive DFS by adding curr element to sides one by one.
        // If any combination is true, return true.
        return (dfs(s1 + arr[k], s2, s3, s4, arr, k - 1, len) ||
                dfs(s1, s2 + arr[k], s3, s4, arr, k - 1, len) ||
                dfs(s1, s2, s3 + arr[k], s4, arr, k - 1, len) ||
                dfs(s1, s2, s3, s4 + arr[k], arr, k - 1, len));
    }


    /*
    回溯
     */
    public boolean makesquare2(int[] matchsticks) {

        int total = 0;

        for (int i : matchsticks) {
            total += i;
        }

        if (total % 4 != 0) return false; // if we cant make 4 equals sides then theres no way to make a square
        // sort the array and place the largest sides first. required optimization to not TLE
        Arrays.sort(matchsticks);
        return match(matchsticks, matchsticks.length - 1, 0, 0, 0, 0, total / 4);
    }

    public boolean match(int[] matchsticks, int index, int top, int bottom, int left, int right, int target) {

        if (top == target && bottom == target && left == target && right == target)
            return true;

        if (top > target || bottom > target || left > target || right > target)
            return false;

        int val = matchsticks[index];

        boolean t = match(matchsticks, index - 1, top + val, bottom, left, right, target);
        if (t) return true;
        boolean b = match(matchsticks, index - 1, top, bottom + val, left, right, target);
        if (b) return true;
        boolean l = match(matchsticks, index - 1, top, bottom, left + val, right, target);
        if (l) return true;
        boolean r = match(matchsticks, index - 1, top, bottom, left, right + val, target);
        if (r) return true;

        return false;
    }


    public static void main(String[] args) {

        L473_Matchsticks_to_Square s = new L473_Matchsticks_to_Square();

        long sysDate1 = System.currentTimeMillis();

        int[] matchsticks = {1, 1, 2, 2, 2};
        boolean res = s.makesquare(matchsticks);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}