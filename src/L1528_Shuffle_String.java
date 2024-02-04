public class L1528_Shuffle_String {


    public String restoreString(String s, int[] indices) {

        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[indices[i]] = s.charAt(i);
        }

        //        StringBuilder sb = new StringBuilder();
        //        for (int i = 0; i < res.length; i++) {
        //            sb.append(res[i]);
        //        }
        //
        //        return sb.toString();

        return String.valueOf(res);
    }

    public static void main(String[] args) {

        L1528_Shuffle_String s =
                new L1528_Shuffle_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String res = s.restoreString(ss, indices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}