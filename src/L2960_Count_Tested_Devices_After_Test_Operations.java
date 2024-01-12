public class L2960_Count_Tested_Devices_After_Test_Operations {

    /*
    1 <= n == batteryPercentages.length <= 100
    0 <= batteryPercentages[i] <= 100
     */
    public int countTestedDevices(int[] batteryPercentages) {

        int ans = 0;

        for (int x : batteryPercentages) {
            if (x > ans) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2960_Count_Tested_Devices_After_Test_Operations s = new L2960_Count_Tested_Devices_After_Test_Operations();
        long sysDate1 = System.currentTimeMillis();

        int[] batteryPercentages = {1, 1, 2, 1, 3};
        int res = s.countTestedDevices(batteryPercentages);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}