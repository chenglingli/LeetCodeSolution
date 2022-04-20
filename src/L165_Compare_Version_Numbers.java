public class L165_Compare_Version_Numbers {

    public int compareVersion(String version1, String version2) {

        String [] valStrList1 = version1.split("\\.");
        String [] valStrList2 = version2.split("\\.");
        int i = 0;
        int j = 0;

        while (i < valStrList1.length && j < valStrList2.length) {
            int temp1 = Integer.parseInt(valStrList1[i]);
            int temp2 = Integer.parseInt(valStrList2[j]);
            if (temp1 > temp2) {
                return 1;
            }
            else if (temp1 < temp2) {
                return -1;
            }
            i++;
            j++;
        }

        while (i < valStrList1.length) {
            int temp1 = Integer.parseInt(valStrList1[i]);
            if (temp1 != 0) {
                return 1;
            }
            i++;
        }

        while (j < valStrList2.length) {
            int temp2 = Integer.parseInt(valStrList2[j]);
            if (temp2 != 0) {
                return -1;
            }
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {

        L165_Compare_Version_Numbers s = new L165_Compare_Version_Numbers();
        long sysDate1 = System.currentTimeMillis();

        int res = s.compareVersion("1.0", "1.0.1");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}