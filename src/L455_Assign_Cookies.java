import java.util.Arrays;

public class L455_Assign_Cookies {

    public int findContentChildren(int[] g, int[] s) {

        int res = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }

            if (j == s.length) {
                break;
            }

            res++;

            i++;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {

        L455_Assign_Cookies s = new L455_Assign_Cookies();

        long sysDate1 = System.currentTimeMillis();
        int[] g = {1, 2, 3};
        int[] ss = {1, 1};
        int res = s.findContentChildren(g, ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}