public class L344_Reverse_String {



    public void reverseString(char[] s) {

        int i = 0;
        int j = s.length-1;
        while (i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }

    public static void main(String[] args) {

        L344_Reverse_String s = new L344_Reverse_String();
        long sysDate1 = System.currentTimeMillis();
        char[] str = {'s', 'o', 'l'};
        s.reverseString(str);
        System.out.println(str);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}