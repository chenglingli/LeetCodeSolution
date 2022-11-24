public class L434_Number_of_Segments_in_a_String {

    public int countSegments(String s) {
        String[] splitList = s.split(" ");
        int count = 0;
        for (String str : splitList) {
            if (str.length() == 0) {
                count++;
            }
        }
        return splitList.length - count;
    }

    public static void main(String[] args) {

        L434_Number_of_Segments_in_a_String s = new L434_Number_of_Segments_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        String num1 = "1  2  ";
        // String num1 = "1 2";

        int res = s.countSegments(num1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}