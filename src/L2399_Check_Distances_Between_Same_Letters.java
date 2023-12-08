public class L2399_Check_Distances_Between_Same_Letters {

    public boolean checkDistances(String s, int[] distance) {
        int[] count = new int[27];
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            count[x] = count[x] == 0 ? i : i - count[x];
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                if (count[i] != distance[i] + 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L2399_Check_Distances_Between_Same_Letters s =
                new L2399_Check_Distances_Between_Same_Letters();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean res = s.checkDistances(ss, distance);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}