import java.util.ArrayList;
import java.util.List;

public class L1431_Kids_With_the_Greatest_Number_of_Candies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();

        int max = -1;
        for (int j : candies) {
            max = Math.max(j, max);
        }

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1431_Kids_With_the_Greatest_Number_of_Candies s = new L1431_Kids_With_the_Greatest_Number_of_Candies();
        long sysDate1 = System.currentTimeMillis();

        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> res = s.kidsWithCandies(candies, extraCandies);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}