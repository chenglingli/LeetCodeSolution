import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1854_Maximum_Population_Year {

    /*

        1 <= logs.length <= 100
        1950 <= birthi < deathi <= 2050

        the person is not counted in the year that they die.

        答案年份肯定是某一段life的开头年份

         */
    public int maximumPopulation(int[][] logs) {
        int[] count = new int[101];
        List<Integer> optionalAns = new ArrayList<>();

        for (int[] log : logs) {
            optionalAns.add(log[0]);
            for (int i = log[0]; i < log[1]; i++) {
                count[i - 1950]++;
            }
        }

        int ans = 0;
        int max = 0;
        Collections.sort(optionalAns);

        for (int x : optionalAns) {
            if (count[x - 1950] > max) {
                max = count[x - 1950];
                ans = x;
            }
        }

        return ans;
    }

    public int maximumPopulation2(int[][] logs) {
        final int[] population = new int[101];
        for (int[] log : logs) {
            population[log[0] - 1950]++;
            population[log[1] - 1950]--;
        }

        for (int i = 1; i < population.length; i++) {
            population[i] += population[i - 1];
        }

        int year = logs[0][0];
        int max = 0;
        for (int i = 0; i < population.length; i++) {
            if (population[i] > max) {
                max = population[i];
                year = 1950 + i;
            }
        }
        return year;
    }

    public static void main(String[] args) {

        L1854_Maximum_Population_Year s = new L1854_Maximum_Population_Year();
        long sysDate1 = System.currentTimeMillis();

        int[][] logs = {{1950, 1961}, {1961, 1971}, {1970, 1981}};
        //        int[][] logs = {{2033, 2034}, {2039, 2047},
        //                {1998, 2042}, {2047, 2048},
        //                {2025, 2029}, {2005, 2044},
        //                {1990, 1992},
        //                {1952, 1956},
        //                {1984, 2014}};
        int res = s.maximumPopulation2(logs);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}