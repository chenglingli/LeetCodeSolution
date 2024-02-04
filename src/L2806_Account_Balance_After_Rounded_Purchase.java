public class L2806_Account_Balance_After_Rounded_Purchase {

    /*
    0 <= purchaseAmount <= 100

    1 - 0
    2
    3
    4
    5 - 10
    6
    7
    8
    9
    10 - 10
    11 - 10
    12
    13
    14
    15 - 20

     */
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int initAmount = 100;
        int res = initAmount - ((purchaseAmount + 5) / 10) * 10;
        return res;
    }

    public static void main(String[] args) {

        L2806_Account_Balance_After_Rounded_Purchase s = new L2806_Account_Balance_After_Rounded_Purchase();
        long sysDate1 = System.currentTimeMillis();

        int purchaseAmount = 13;
        int res = s.accountBalanceAfterPurchase(purchaseAmount);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}