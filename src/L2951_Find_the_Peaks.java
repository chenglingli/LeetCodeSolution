import java.util.ArrayList;
import java.util.List;

public class L2951_Find_the_Peaks {

    /*
    3 <= mountain.length <= 100
    1 <= mountain[i] <= 100
     */
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < mountain.length - 1; ) {
            if (mountain[i - 1] < mountain[i] && mountain[i + 1] < mountain[i]) {
                res.add(i);
                i += 2;
            } else {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2951_Find_the_Peaks s = new L2951_Find_the_Peaks();
        long sysDate1 = System.currentTimeMillis();

        int[] mountain = {1, 4, 3, 8, 5};
        List<Integer> res = s.findPeaks(mountain);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}