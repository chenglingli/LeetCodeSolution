public class L2073_Time_Needed_to_Buy_Tickets {

    /*
    n == tickets.length
    1 <= n <= 100
    1 <= tickets[i] <= 100
    0 <= k < n

    2 3 2
    1 2 1
    0 1 0

    6


     */
    public int timeRequiredToBuy2(int[] tickets, int k) {

        int ans = 0;
        int level = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                ans += Math.min(tickets[i], level);
            } else {
                ans += Math.min(tickets[i], level - 1);
            }
        }

        return ans;
    }

    public int timeRequiredToBuy(int[] tickets, int k) {

        int ans = 0;

        while (tickets[k] > 0) {

            for (int i = 0; i < tickets.length; i++) {

                if (i == k) {
                    if (tickets[i] > 0) {
                        tickets[i]--;
                        ans++;
                        if (tickets[i] == 0) {
                            return ans;
                        }
                    }
                } else if (tickets[i] > 0) {
                    tickets[i]--;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2073_Time_Needed_to_Buy_Tickets s = new L2073_Time_Needed_to_Buy_Tickets();
        long sysDate1 = System.currentTimeMillis();

        //        int[] tickets = {84, 49, 5, 24, 70, 77, 87, 8};
        //        int k = 3;

        int[] tickets = {2, 3, 2};
        int k = 0;

        int res = s.timeRequiredToBuy2(tickets, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}