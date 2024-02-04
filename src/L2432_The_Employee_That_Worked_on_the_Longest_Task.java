public class L2432_The_Employee_That_Worked_on_the_Longest_Task {

    public int hardestWorker(int n, int[][] logs) {
        int[] duration = new int[n];
        int lastLeaveTime = 0;
        for (int[] log : logs) {
            int curWorker = log[0];
            int leaveTime = log[1];

            duration[curWorker] = Math.max(duration[curWorker], leaveTime - lastLeaveTime);

            lastLeaveTime = leaveTime;
        }

        int max = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (duration[i] > max) {
                max = duration[i];
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2432_The_Employee_That_Worked_on_the_Longest_Task s = new L2432_The_Employee_That_Worked_on_the_Longest_Task();
        long sysDate1 = System.currentTimeMillis();

        int n = 10;
        int[][] logs = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        int res = s.hardestWorker(n, logs);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}