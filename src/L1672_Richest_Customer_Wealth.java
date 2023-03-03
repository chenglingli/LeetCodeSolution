public class L1672_Richest_Customer_Wealth {


    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 1; j < accounts[0].length; j++) {
                accounts[i][0] += accounts[i][j];
            }
            max = Math.max(accounts[i][0], max);
        }
        return max;
    }

    public static void main(String[] args) {

        L1672_Richest_Customer_Wealth s = new L1672_Richest_Customer_Wealth();
        long sysDate1 = System.currentTimeMillis();

        int[][] accounts = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        int res = s.maximumWealth(accounts);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}