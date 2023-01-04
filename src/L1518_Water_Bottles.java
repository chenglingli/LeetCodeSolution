public class L1518_Water_Bottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;

        int curDrink = numBottles;
        int totalBottles = numBottles;

        res += curDrink;
        while (totalBottles >= numExchange) {

            curDrink = totalBottles / numExchange;
            totalBottles = curDrink + totalBottles % numExchange;

            res += curDrink;
        }

        return res;
    }

    public static void main(String[] args) {

        L1518_Water_Bottles s = new L1518_Water_Bottles();
        long sysDate1 = System.currentTimeMillis();

        int numBottles = 9;
        int numExchange = 3;
        int res = s.numWaterBottles(numBottles, numExchange);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}