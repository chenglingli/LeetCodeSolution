public class L1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {

    public double average(int[] salary) {

        int max = 999;
        int min = 1000001;
        int sum = 0;

        for (int j : salary) {
            max = Math.max(j, max);
            min = Math.min(j, min);
            sum += j;
        }

        sum = sum - max - min;
        return  (sum * 1.0) / (salary.length - 2);
    }

    public static void main(String[] args) {

        L1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary s = new L1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary();
        long sysDate1 = System.currentTimeMillis();

        int[] salary = {4000, 3000, 1000, 2000};
        double res = s.average(salary);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}