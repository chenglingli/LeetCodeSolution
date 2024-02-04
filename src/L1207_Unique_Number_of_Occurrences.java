public class L1207_Unique_Number_of_Occurrences {

    /*

    1 <= arr.length <= 1000
    -1000 <= arr[i] <= 1000

     */
    public boolean uniqueOccurrences(int[] arr) {

        int[] count = new int[2002];
        int[] map = new int[1001];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (map[count[i]] == 1) {
                    return false;
                } else {
                    map[count[i]] = 1;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L1207_Unique_Number_of_Occurrences s = new L1207_Unique_Number_of_Occurrences();
        long sysDate1 = System.currentTimeMillis();

        //        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        int[] arr = {1, 2};
        boolean res = s.uniqueOccurrences(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}