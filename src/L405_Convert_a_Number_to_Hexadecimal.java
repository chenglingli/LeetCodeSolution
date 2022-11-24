public class L405_Convert_a_Number_to_Hexadecimal {


    public String toHex(int num) {
        char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder sb = new StringBuilder();
        do {

            sb.append(hex[num & 15]);                          // convert decimal to hex
            num >>>= 4;                                        // equal num /= 16 = 2 ^ 4

        } while (num != 0);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        L405_Convert_a_Number_to_Hexadecimal s = new L405_Convert_a_Number_to_Hexadecimal();

        long sysDate1 = System.currentTimeMillis();


        String res = s.toHex(-1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}