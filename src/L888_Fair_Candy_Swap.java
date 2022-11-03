import java.util.Arrays;

public class L888_Fair_Candy_Swap {
    
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sum1 = 0;
        for (int aliceSize : aliceSizes) {
            sum1 += aliceSize;
        }

        int sum2 = 0;
        for (int bobSize : bobSizes) {
            sum2 += bobSize;
        }

        int diff = (sum1 - sum2) / 2;

        for (int i = aliceSizes.length - 1; i >= 0; i--) {
            for (int j = bobSizes.length - 1; j >= 0; j--) {
                if (aliceSizes[i] == bobSizes[j] + diff) {
                    return new int[]{aliceSizes[i], bobSizes[j]};
                }
            }
        }

        return aliceSizes;
    }

    public static void main(String[] args) {

        L888_Fair_Candy_Swap s = new L888_Fair_Candy_Swap();

        long sysDate1 = System.currentTimeMillis();
        // int [] nums = {2, 5, 4, 8, 10, 9, 15};
        // int [] nums = {3,1,2,4};
        int[] aliceSizes = {2, 1};
        int[] bobSizes = {2, 3};
        int[] res = s.fairCandySwap(aliceSizes, bobSizes);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}