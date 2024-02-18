public class L134_Gas_Station {

    /*
    n == gas.length == cost.length
    1 <= n <= 10^5
    0 <= gas[i], cost[i] <= 10^4

    不能绕群的条件：
        sum of gas < sum of cost

    如果能绕圈，则可以尝试每个起点index:
        sum记录index开始到当前为止的余量x
        如果x < 0， 则重置起点index = i + 1, 重置sum

     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0, available = 0, startIndex = 0;

        for (int i = 0; i < gas.length; i++) {

            total += gas[i] - cost[i];

            available += gas[i] - cost[i];
            if (available < 0) {
                available = 0;
                startIndex = i + 1;
            }
        }

        return total < 0 ? -1 : startIndex;
    }


    public static void main(String[] args) {

        L134_Gas_Station s = new L134_Gas_Station();
        long sysDate1 = System.currentTimeMillis();

        //        int[] gas = {1, 2, 3, 4, 5};
        //        int[] cost = {3, 4, 5, 1, 2};

        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        int res = s.canCompleteCircuit(gas, cost);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}