public class L2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {

    /*
    n == blocks.length
    1 <= n <= 100
    blocks[i] is either 'W' or 'B'.
    1 <= k <= n
     */
    public int minimumRecolors(String blocks, int k) {

        int maxCount = 0;
        int n = blocks.length();
        int i = 0;

        int tempCount = 0;

        while (i < k) {
            if (blocks.charAt(i) == 'B') {
                tempCount++;
            }
            i++;
        }

        maxCount = Math.max(maxCount, tempCount);
        if (maxCount == k) {
            return 0;
        }

        while (i < n) {

            if (blocks.charAt(i) == 'B') {
                tempCount++;
            }
            if (blocks.charAt(i - k) == 'B') {
                tempCount--;
            }

            maxCount = Math.max(maxCount, tempCount);
            if (maxCount == k) {
                return 0;
            }

            i++;
        }

        return k - maxCount;
    }

    public int minimumRecolors2(String blocks, int k) {

        int min = 0, curr = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W')
                curr++;
        }

        min = curr;
        int j = 0;

        for (int i = k; i < blocks.length(); i++) {

            if (blocks.charAt(i) == 'W')
                curr++;

            if (blocks.charAt(j) == 'W')
                curr--;

            if (curr < min)
                min = curr;

            if (curr == 0)
                return curr;

            j++;
        }
        return min;
    }

    public static void main(String[] args) {

        L2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks s =
                new L2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks();
        long sysDate1 = System.currentTimeMillis();

        String blocks = "WBBWWBBWBW";
        int k = 7;

        int res = s.minimumRecolors(blocks, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}