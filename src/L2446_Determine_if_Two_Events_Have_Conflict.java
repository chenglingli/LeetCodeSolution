public class L2446_Determine_if_Two_Events_Have_Conflict {

    public boolean haveConflict(String[] event1, String[] event2) {

        if (isSmallAndEqualThan(event1[0], event2[0]) && isSmallAndEqualThan(event2[1], event1[1])) {
            return true;
        }

        if (isSmallAndEqualThan(event2[0], event1[0]) && isSmallAndEqualThan(event1[1], event2[1])) {
            return true;
        }

        if (isSmallAndEqualThan(event1[0], event2[1]) && isSmallAndEqualThan(event2[0], event1[0])) {
            return true;
        }

        if (isSmallAndEqualThan(event1[1], event2[1]) && isSmallAndEqualThan(event2[0], event1[1])) {
            return true;
        }

        return false;
    }

    private boolean isSmallAndEqualThan(String a, String b) {
        String[] aArray = a.split(":");
        String[] bArray = b.split(":");
        if (Integer.parseInt(aArray[0]) < Integer.parseInt(bArray[0]) ||

                Integer.parseInt(aArray[0]) == Integer.parseInt(bArray[0])
                        && Integer.parseInt(aArray[1]) <= Integer.parseInt(bArray[1])
        ) {
            return true;
        }
        return false;
    }

    public boolean haveConflict2(String[] event1, String[] event2) {

        if (event1[0].compareTo(event2[0]) == 0) {
            return true;
        }

        if (event1[0].compareTo(event2[0]) < 0) {
            return event1[1].compareTo(event2[0]) >= 0;
        } else {
            return event2[1].compareTo(event1[0]) >= 0;
        }
    }

    public static void main(String[] args) {

        L2446_Determine_if_Two_Events_Have_Conflict s = new L2446_Determine_if_Two_Events_Have_Conflict();
        long sysDate1 = System.currentTimeMillis();

        String[] a = {"01:15", "02:00"};
        String[] b = {"02:00", "03:00"};
        boolean res = s.haveConflict(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}