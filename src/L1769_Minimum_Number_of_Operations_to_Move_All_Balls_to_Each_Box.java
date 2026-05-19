import java.util.Arrays;

public class L1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {


    /*

    You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.

    In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
    Note that after doing so, there may be more than one ball in some boxes.

    Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.

    Each answer[i] is calculated considering the initial state of the boxes.



    Example 1:

    Input: boxes = "110"
    Output: [1,1,3]
    Explanation: The answer for each box is as follows:
    1) First box: you will have to move one ball from the second box to the first box in one operation.
    2) Second box: you will have to move one ball from the first box to the second box in one operation.
    3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
    Example 2:

    Input: boxes = "001011"
    Output: [11,8,5,4,3,4]


    Constraints:

    n == boxes.length
    1 <= n <= 2000
    boxes[i] is either '0' or '1'.

     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    res[i] += Math.abs(i - j);
                }
            }
        }

        return res;
    }

    public int[] minOperations2(String boxes) {

        int n = boxes.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = boxes.charAt(i) - '0'; // '0'/'1' -> 0/1
        int[] pref = new int[n]; // pref[i]: 左侧所有球移到 i 的总代价
        int[] suf = new int[n];  // suf[i]:  右侧所有球移到 i 的总代价

        // 从左到右：目标盒子每右移一格，左侧每个球多走 1 步
        // 左侧每个球多走1步，其实就是oneCnt的值
        int oneCnt = 0;      // i 左侧（不含 i）的球数
        oneCnt = arr[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + oneCnt;
            oneCnt += arr[i];
        }

        // 从右到左：目标盒子每左移一格，右侧每个球多走 1 步
        oneCnt = arr[n - 1]; // i 右侧（不含 i）的球数
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + oneCnt;
            oneCnt += arr[i];
        }

        // answer[i] = sum |i-j| = 左侧代价 + 右侧代价
        for (int i = 0; i < n; i++) {
            arr[i] = pref[i] + suf[i];
        }

        return arr;
    }

    public static void main(String[] args) {

        L1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box s = new L1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box();
        long sysDate1 = System.currentTimeMillis();

        String boxes = "001011";
        int[] res = s.minOperations(boxes);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}