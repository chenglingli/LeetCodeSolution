import java.util.Arrays;

public class Solution {

    /**
     *

     Given a valid (IPv4) IP address, return a defanged version of that IP address.

     A defanged IP address replaces every period "." with "[.]".


     Example 1:

     Input: address = "1.1.1.1"
     Output: "1[.]1[.]1[.]1"
     Example 2:

     Input: address = "255.100.50.0"
     Output: "255[.]100[.]50[.]0"

     */

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address);
        int cur = 0;
        int location = 1;
        while (location != -1) {
            location = sb.indexOf(".", cur);
            if (location == -1) {
                return sb.toString();
            }
            sb.replace(location, location + 1, "[.]");
            cur = location + 3;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        long sysDate1 = System.currentTimeMillis();

        String nums = "255.100.50.0";
        String res = s.defangIPaddr(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}