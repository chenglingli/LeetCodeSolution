public class L168_Excel_Sheet_Column_Title {

    public String convertToTitle(int columnNumber) {

        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int x = 'A' + (columnNumber % 26);
            char temp = (char) x;

            res.append(temp);
            columnNumber = columnNumber / 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {

        L168_Excel_Sheet_Column_Title s = new L168_Excel_Sheet_Column_Title();
        long sysDate1 = System.currentTimeMillis();

        String res = s.convertToTitle(701);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}