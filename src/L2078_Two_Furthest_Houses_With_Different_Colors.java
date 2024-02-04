public class L2078_Two_Furthest_Houses_With_Different_Colors {

    /*
    n == colors.length
    2 <= n <= 100
    0 <= colors[i] <= 100
    Test data are generated such that at least two houses have different colors.
     */
    public int maxDistance(int[] colors) {

        if (colors[0] != colors[colors.length - 1]) {
            return colors.length - 1;
        }

        int i = 0;
        int j = colors.length - 1;

        while (colors[i + 1] == colors[i]) {
            i++;
        }
        i++;

        while (colors[j - 1] == colors[j]) {
            j--;
        }
        j--;

        return Math.max(colors.length - 1 - i, j);
    }

    public static void main(String[] args) {

        L2078_Two_Furthest_Houses_With_Different_Colors s = new L2078_Two_Furthest_Houses_With_Different_Colors();
        long sysDate1 = System.currentTimeMillis();

        int[] colors = {1, 1, 1, 6, 1, 1, 1};
        //        int[] colors = {1, 8, 3, 8, 3};


        int res = s.maxDistance(colors);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}