public class L605_Can_Place_Flowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 1) {
                continue;
            }

            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0)
                        && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                    flowerbed[i] = 1;
                    count++;

                    if(count >= n ) {
                        return true;
                    }
                }
            }

        }

        return count >= n;
    }

    public static void main(String[] args) {

        L605_Can_Place_Flowers s = new L605_Can_Place_Flowers();
        long sysDate1 = System.currentTimeMillis();

        int[] input = {1,0,0,0,0,0};
        int n = 3;

        boolean res = s.canPlaceFlowers(input, n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}