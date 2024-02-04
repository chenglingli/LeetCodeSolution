import java.util.HashMap;
import java.util.Map;

public class L1507_Reformat_Date {

    public String reformatDate(String date) {

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String[] dateList = date.split(" ");
        String d = dateList[0];
        String m = dateList[1];
        String y = dateList[2];

        StringBuilder res = new StringBuilder();

        res.append(y);
        res.append("-");

        res.append(monthMap.get(m));
        res.append("-");

        if (d.length() == 4) {
            res.append(d.substring(0, 2));
        } else {
            res.append("0");
            res.append(d.substring(0, 1));
        }


        return res.toString();
    }


    public static void main(String[] args) {

        L1507_Reformat_Date s = new L1507_Reformat_Date();
        long sysDate1 = System.currentTimeMillis();

        String date = "5th Oct 2052";
        String res = s.reformatDate(date);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}