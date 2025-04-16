public class L1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position {

    /*

    We have n chips, where the position of the ith chip is position[i].

    We need to move all the chips to the same position.
    In one step, we can change the position of the ith chip from position[i] to:

    position[i] + 2 or position[i] - 2 with cost = 0.
    position[i] + 1 or position[i] - 1 with cost = 1.
    Return the minimum cost needed to move all the chips to the same position.



    Example 1:
    Input: position = [1,2,3]
    Output: 1
    Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
    Second step: Move the chip at position 2 to position 1 with cost = 1.
    Total cost is 1.


    Example 2:
    Input: position = [2,2,2,3,3]

    Output: 2
    Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.


    Example 3:

    Input: position = [1,1000000000]
    Output: 1


    Constraints:

    1 <= position.length <= 100
    1 <= position[i] <= 10^9

     */
    public int minCostToMoveChips(int[] position) {

        // 间隔1，成本为1；间隔2，成本为0
        // 先把所有移到0或者1，成本为0
        // 再看哪个少，成本为少的那个

        int oddCount = 0;
        for (int x : position) {
            if (x % 2 == 1) {
                oddCount++;
            }
        }
        int evenCount = position.length - oddCount;
        return Math.min(oddCount, evenCount);
    }

    public static void main(String[] args) {

        L1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position s = new L1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position();
        long sysDate1 = System.currentTimeMillis();

        int[] position = {1, 2, 3};

        int res = s.minCostToMoveChips(position);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}