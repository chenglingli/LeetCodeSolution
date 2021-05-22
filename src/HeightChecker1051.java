import java.util.Arrays;

public class HeightChecker1051 {

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

        HeightChecker1051 s = new HeightChecker1051();

        long sysDate1 = System.currentTimeMillis();


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}