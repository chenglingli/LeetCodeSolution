public class L875_Koko_Eating_Bananas {

    /**
     *
     Koko loves to eat bananas.
     There are N piles of bananas,
     the i-th pile has piles[i] bananas.
     The guards have gone and will come back in H hours.

     Koko can decide her bananas-per-hour eating speed of K.
     Each hour, she chooses some pile of bananas, and eats K bananas from that pile.
     If the pile has less than K bananas, she eats all of them instead,
     and won't eat any more bananas during this hour.

     Koko likes to eat slowly,
     but still wants to finish eating all the bananas before the guards come back.

     Return the minimum integer K such that she can eat all the bananas within H hours.

     Example 1:

     Input: piles = [3,6,7,11], H = 8
     Output: 4

     Example 2:

     Input: piles = [30,11,23,4,20], H = 5
     Output: 30

     Example 3:

     Input: piles = [30,11,23,4,20], H = 6
     Output: 23


     Note:

     1 <= piles.length <= 10^4
     piles.length <= H <= 10^9
     1 <= piles[i] <= 10^9

     */

    public int minEatingSpeed(int[] piles, int H) {

        long left = 1, right = 100000;

        while (left < right) {
            long mid = left + (right - left) / 2, cnt = 0;

            for (int pile : piles)
                cnt += (pile + mid - 1) / mid;

            if (cnt > H)
                left = mid + 1;
            else
                right = mid;
        }

        return (int)left;
    }

    public int minEatingSpeed2(int[] piles, int H) {

        long sum = 0, max = 0;
        for (int pile : piles) {
            sum += pile;
            max = Math.max(max, pile);
        }

        if (piles.length == H) {
            return (int) max;
        }

        long left = (int) (sum / (long) H) + 1, right = 100000;

        while (left < right) {
            long mid = left + (right - left) / 2, cnt = 0;

            for (int pile : piles)
                cnt += (pile + mid - 1) / mid;

            if (cnt > H)
                left = mid + 1;
            else
                right = mid;
        }

        return (int)left;
    }

    public int minEatingSpeed3(int[] piles, int H) {

        long sum = 0, max = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            max = Math.max(max, piles[i]);
        }

        if (piles.length == H) {
            return (int) max;
        }

        int min = (int) (sum / (long) H) + 1;

        while (true) {
            int hour = 0;
            for (int pile : piles) {
                hour += (pile - 1) / min + 1;
            }

            if (hour <= H) {
                return min;
            }

            ++min;
        }
    }

    public static void main(String[] args) {

        L875_Koko_Eating_Bananas s = new L875_Koko_Eating_Bananas();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {30,11,23,4,20};
        int res = s.minEatingSpeed2(nums, 6);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}