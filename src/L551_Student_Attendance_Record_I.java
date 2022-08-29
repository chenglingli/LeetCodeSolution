public class L551_Student_Attendance_Record_I {

    public boolean checkRecord(String s) {

        int absentCount = 0;
        for (int i = 0 ; i < s.length() ; i++) {

            char cur = s.charAt(i);

            switch (cur) {
                case 'A':
                    absentCount ++ ;
                    if (absentCount >= 2) {
                        return false;
                    }
                    break;

                case 'L':
                    if (i >= 2 && s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L')
                        return false;
                    break;

                case 'P':
                    break;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        L551_Student_Attendance_Record_I s = new L551_Student_Attendance_Record_I();
        long sysDate1 = System.currentTimeMillis();
        String ss = "PPALLP";
        boolean res = s.checkRecord(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}