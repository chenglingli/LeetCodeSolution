public class L1346_Check_If_N_and_Its_Double_Exist {

    /*
        2 <= arr.length <= 500
        -10^3 <= arr[i] <= 10^3
     */

    public boolean checkIfExist(int[] arr) {

        int[] positiveMark = new int[2002];
        int[] negativeMark = new int[2002];

        for (int cur : arr) {

            if (cur >= 0) {
                if (positiveMark[cur] == 1) {
                    return true;
                }
                if (cur % 2 == 0) {
                    positiveMark[cur / 2] = 1;
                }
                positiveMark[cur * 2] = 1;
            } else {
                cur = cur * -1;
                if (negativeMark[cur] == 1) {
                    return true;
                }
                if (cur % 2 == 0) {
                    negativeMark[cur / 2] = 1;
                }
                negativeMark[cur * 2] = 1;
            }
        }

        return false;
    }

    public boolean checkIfExist2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (checkCondition(arr, i))
                return true;
        }
        return false;
    }

    private boolean checkCondition(int[] arr, int idx) {
        for (int j = idx + 1; j < arr.length; j++) {
            if (arr[idx] == 2 * arr[j] || 2 * arr[idx] == arr[j])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        L1346_Check_If_N_and_Its_Double_Exist s = new L1346_Check_If_N_and_Its_Double_Exist();
        long sysDate1 = System.currentTimeMillis();

        int[] num = {3, 0, 0, 1000, -1000};
        boolean res = s.checkIfExist(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}