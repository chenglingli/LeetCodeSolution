public class L2269_Find_the_K_Beauty_of_a_Number {

    public int divisorSubstrings(int num, int k) {

        int ans = 0;

        String numStr = Integer.toString(num);
        int n = numStr.length();

        for (int i = 0; i < n - k + 1; i++) {
            String cur = numStr.substring(i, i + k);
            int curNum = Integer.parseInt(cur);

            if (curNum != 0 && num % curNum == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2269_Find_the_K_Beauty_of_a_Number s =
                new L2269_Find_the_K_Beauty_of_a_Number();
        long sysDate1 = System.currentTimeMillis();

        int num = 430043;
        int k = 2;
        int res = s.divisorSubstrings(num, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}