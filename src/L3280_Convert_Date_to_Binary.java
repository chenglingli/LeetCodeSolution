public class L3280_Convert_Date_to_Binary {
    
    public String convertDateToBinary(String date) {
        String[] dateArr = date.split("-");
        dateArr[0] = Integer.toBinaryString(Integer.parseInt(dateArr[0]));
        dateArr[1] = Integer.toBinaryString(Integer.parseInt(dateArr[1]));
        dateArr[2] = Integer.toBinaryString(Integer.parseInt(dateArr[2]));
        return dateArr[0] + "-" + dateArr[1] + "-" + dateArr[2];
    }

    public static void main(String[] args) {

        L3280_Convert_Date_to_Binary s = new L3280_Convert_Date_to_Binary();
        long sysDate1 = System.currentTimeMillis();

        String date = "1900-01-01";
        String date2 = "2080-02-29";

        String res = s.convertDateToBinary(date);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}