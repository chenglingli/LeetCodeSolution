
public class L171_Excel_Sheet_Column_Number {

    public int titleToNumber(String columnTitle) {

        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char temp = columnTitle.charAt(i);
            res *= 26;
            res += temp - 'A' + 1;
        }

        return res;
    }

    public static void main(String[] args) {

        L171_Excel_Sheet_Column_Number s = new L171_Excel_Sheet_Column_Number();
        long sysDate1 = System.currentTimeMillis();

        int res = s.titleToNumber("AB");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}