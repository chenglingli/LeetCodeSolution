public class L2315_Count_Asterisks {

    public int countAsterisks(String s) {
        int ans = 0;

        String[] sArray = s.split("\\|");
        for (int i = 0; i < sArray.length; i = i + 2) {
            String cur = sArray[i];
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) == '*') {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int countAsterisks2(String s) {
        int ans = 0;

        String[] sArray = s.split("\\|");
        for (int i = 0; i < sArray.length; i = i + 2) {
            char[] ch = sArray[i].toCharArray();
            for (char c : ch) {
                if (c == '*') {
                    ans++;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        L2315_Count_Asterisks s =
                new L2315_Count_Asterisks();
        long sysDate1 = System.currentTimeMillis();

        String ss = "yo|uar|e**|b|e***au|tifu|l";
        int res = s.countAsterisks2(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}