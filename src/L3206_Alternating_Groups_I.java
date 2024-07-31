public class L3206_Alternating_Groups_I {

    /*
    3 <= colors.length <= 100
    0 <= colors[i] <= 1
     */
    public int numberOfAlternatingGroups(int[] colors) {

        int res = 0;
        int i = 0;
        int n = colors.length;

        while (i < colors.length) {
            if (colors[i] == colors[(i + 2) % n] && colors[i] != colors[(i + 1) % n]) {
                res++;
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {

        L3206_Alternating_Groups_I s = new L3206_Alternating_Groups_I();
        long sysDate1 = System.currentTimeMillis();

        int[] colors = {0, 1, 0, 0, 1};
        int res = s.numberOfAlternatingGroups(colors);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}