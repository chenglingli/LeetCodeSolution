public class L696_Count_Binary_Substrings {

    /*
    10101
    00110011
    1 <= s.length <= 105
    s[i] is either '0' or '1'.


    00110011

    0011
    01
    1100
    10
    0011
    01

     */


    /*

    group 实现01的count编码，譬如 几个1 几个0 几个1 几个0

     */
    public int countBinarySubstrings(String s) {
        int[] group = new int[s.length()];
        group[0] = 1;
        int t = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                group[++t] = 1;
            } else {
                group[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {     // for(int i=1;i<=t;i++) this is also correct
            ans += Math.min(group[i - 1], group[i]);
        }
        return ans;
    }


    public int countBinarySubstrings3(String s) {

        int count = 0;
        char[] arr = s.toCharArray();
        if (arr.length == 0)
            return 0;

        int currentCount = 1;
        int stateCount = 0;
        char state = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (state == arr[i]) {

                currentCount++;
                if (stateCount >= currentCount)
                    count++;

            } else {
                state = arr[i];
                stateCount = currentCount;
                currentCount = 1;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L696_Count_Binary_Substrings s = new L696_Count_Binary_Substrings();
        long sysDate1 = System.currentTimeMillis();

        String input = "00001110";
        // String input = "00110";
        int res = s.countBinarySubstrings3(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}