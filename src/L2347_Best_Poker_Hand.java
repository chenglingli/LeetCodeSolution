public class L2347_Best_Poker_Hand {

    /*

    ranks.length == suits.length == 5
    1 <= ranks[i] <= 13
    'a' <= suits[i] <= 'd'
    No two cards have the same rank and suit.

     */
    public String bestHand(int[] ranks, char[] suits) {
//        "Flush": Five cards of the same suit.
//        "Three of a Kind": Three cards of the same rank.
//        "Pair": Two cards of the same rank.
//        "High Card": Any single card.

        if (suits[0] == suits[1]
                && suits[0] == suits[2]
                && suits[0] == suits[3]
                && suits[0] == suits[4]) {
            return "Flush";
        }

        int[] rankArray = new int[14];
        boolean pair = false;
        for (int x : ranks) {
            rankArray[x]++;
            if (rankArray[x] == 2) {
                pair = true;
            }
            if (rankArray[x] == 3) {
                return "Three of a Kind";
            }
        }
        if (pair) {
            return "Pair";
        }

        return "High Card";
    }

    public static void main(String[] args) {

        L2347_Best_Poker_Hand s =
                new L2347_Best_Poker_Hand();
        long sysDate1 = System.currentTimeMillis();

        int[] ranks = {13, 2, 3, 1, 9};
        char[] suits = {'a', 'a', 'a', 'a', 'a'};
        String res = s.bestHand(ranks, suits);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}