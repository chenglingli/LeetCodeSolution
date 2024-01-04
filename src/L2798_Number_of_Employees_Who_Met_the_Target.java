public class L2798_Number_of_Employees_Who_Met_the_Target {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int x : hours) {
            if (x >= target) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2798_Number_of_Employees_Who_Met_the_Target s = new L2798_Number_of_Employees_Who_Met_the_Target();
        long sysDate1 = System.currentTimeMillis();

        int[] hours = {0, 1, 2, 3, 4};
        int target = 2;

        int res = s.numberOfEmployeesWhoMetTarget(hours, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}