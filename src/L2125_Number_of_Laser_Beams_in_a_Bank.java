public class L2125_Number_of_Laser_Beams_in_a_Bank {

    /*

    Anti-theft security devices are activated inside a bank.

    You are given a 0-indexed binary string array bank
    representing the floor plan of the bank,
    which is an m x n 2D matrix.

    bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.

    There is one laser beam between any two security devices if both conditions are met:

    The two devices are located on two different rows: r1 and r2, where r1 < r2.
    For each row i where r1 < i < r2, there are no security devices in the ith row.
    Laser beams are independent, i.e., one beam does not interfere nor join with another.

    Return the total number of laser beams in the bank.



    Example 1:


    Input: bank = ["011001","000000","010100","001000"]
    Output: 8
    Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
     * bank[0][1] -- bank[2][1]
     * bank[0][1] -- bank[2][3]
     * bank[0][2] -- bank[2][1]
     * bank[0][2] -- bank[2][3]
     * bank[0][5] -- bank[2][1]
     * bank[0][5] -- bank[2][3]
     * bank[2][1] -- bank[3][2]
     * bank[2][3] -- bank[3][2]
    Note that there is no beam between any device on the 0th row with any on the 3rd row.
    This is because the 2nd row contains security devices, which breaks the second condition.
    Example 2:


    Input: bank = ["000","111","000"]
    Output: 0
    Explanation: There does not exist two devices located on two different rows.


    Constraints:

    m == bank.length
    n == bank[i].length
    1 <= m, n <= 500
    bank[i][j] is either '0' or '1'.

     */
    public int numberOfBeams(String[] bank) {

        int res = 0;
        int prev = 0;

        for (String row : bank) {
            int cur = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    cur++;
                }
            }

            if (cur == 0) {
                continue;
            }
            res += prev * cur;
            prev = cur;
        }

        return res;
    }

    public int numberOfBeams2(String[] bank) {
        int ans = 0;
        int prev = 0;
        for(String s : bank) {
            int count = countOnes(s);
            if(count != 0) {
                ans += prev * count;
                prev = count;
            }
        }
        return ans;
    }
    private int countOnes(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) count += s.charAt(i) - '0';
        return count;
    }

    public static void main(String[] args) {

        L2125_Number_of_Laser_Beams_in_a_Bank s = new L2125_Number_of_Laser_Beams_in_a_Bank();
        long sysDate1 = System.currentTimeMillis();

        String[] bank = new String[4];
        bank[0] = "011001";
        bank[1] = "000000";
        bank[2] = "010100";
        bank[3] = "001000";

        int res = s.numberOfBeams(bank);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}