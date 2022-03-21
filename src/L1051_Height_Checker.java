import java.util.Arrays;

public class L1051_Height_Checker {

    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(heights);
        int incorrect = 0;
        for (int i = 0; i < heights.length; i++) {
            if (temp[i] != heights[i]) {
                incorrect++;
            }
        }
        return incorrect;
    }


    public static void main(String[] args) {

        L1051_Height_Checker s = new L1051_Height_Checker();

        long sysDate1 = System.currentTimeMillis();


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}