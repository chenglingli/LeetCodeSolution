public class L3226_Number_of_Bit_Changes_to_Make_Two_Integers_Equal {

    public int minChanges(int n, int k) {

        int count = 0;

        if (n < k) {
            return -1;
        }
        if (n == k) {
            return 0;
        }

        while (n > 0 && k >0) {
            int temp1 = n % 2;
            int temp2 = k % 2;
            if (temp1 == 1 && temp2 == 0) {
                count++;
            }
            else if (temp1 == 0 && temp2 == 1) {
                return -1;
            }
            n /= 2;
            k /= 2;
        }

        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }

        return count;
    }

    public static void main(String[] args) {

        L3226_Number_of_Bit_Changes_to_Make_Two_Integers_Equal s = new L3226_Number_of_Bit_Changes_to_Make_Two_Integers_Equal();
        long sysDate1 = System.currentTimeMillis();

        String ss = "aAbBcC";
        int n = 14;
        int k = 13;
        int res = s.minChanges(n, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}