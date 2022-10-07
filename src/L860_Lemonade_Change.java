public class L860_Lemonade_Change {

    public boolean lemonadeChange(int[] bills) {

        // 0: 5
        // 1: 10
        // 2: 20
        int[] count = new int[3];

        for (int bill : bills) {

            if (bill == 5) {
                count[0]++;

            } else if (bill == 10) {
                if (count[0] == 0) {
                    return false;
                }
                count[1]++;
                count[0]--;

            } else {
                if (count[0] >= 1 && count[1] >= 1) {
                    count[0] -= 1;
                    count[1] -= 1;
                } else if (count[0] >= 3) {
                    count[0] -= 3;
                } else {
                    return false;
                }
                count[2]++;

            }
        }

        return true;
    }

    public static void main(String[] args) {

        L860_Lemonade_Change s = new L860_Lemonade_Change();
        long sysDate1 = System.currentTimeMillis();

        int[] bills = {5, 5, 10, 10, 20};
        //        int num = 5;
        boolean res = s.lemonadeChange(bills);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}