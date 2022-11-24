public class L1108_Defanging_an_IP_Address {

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

        L1108_Defanging_an_IP_Address s = new L1108_Defanging_an_IP_Address();
        long sysDate1 = System.currentTimeMillis();

        String nums = "255.100.50.0";
        String res = s.defangIPaddr(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}