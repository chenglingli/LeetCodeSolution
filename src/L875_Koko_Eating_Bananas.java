public class L875_Koko_Eating_Bananas {


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

        return (int) left;
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

        return (int) left;
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

        int[] nums = {30, 11, 23, 4, 20};
        int res = s.minEatingSpeed2(nums, 6);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}