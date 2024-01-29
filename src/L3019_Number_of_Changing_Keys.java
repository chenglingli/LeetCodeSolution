public class L3019_Number_of_Changing_Keys {

    /*
    1 <= s.length <= 100
    s consists of only upper case and lower case English letters.
     */
    public int countKeyChanges(String s) {

        int ans = 0;

        for (int i = 1; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1))) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L3019_Number_of_Changing_Keys s = new L3019_Number_of_Changing_Keys();
        long sysDate1 = System.currentTimeMillis();

        String ss = "aAbBcC";
        int res = s.countKeyChanges(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}