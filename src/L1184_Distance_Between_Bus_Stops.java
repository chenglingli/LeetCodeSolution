public class L1184_Distance_Between_Bus_Stops {

    /*
    1 <= n <= 10^4
    distance.length == n
    0 <= start, destination < n
    0 <= distance[i] <= 10^4
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int lenCount = distance.length;
        int len1 = 0;
        int len2 = 0;

        // 0 -> 3
        for (int i = start; i % lenCount != destination; i++) {
            len1 += distance[i % lenCount];
        }

        // 3 -> 4
        for (int i = destination; i % lenCount != start; i++) {
            len2 += distance[i % lenCount];
        }

        return Math.min(len1, len2);
    }

    public static void main(String[] args) {

        L1184_Distance_Between_Bus_Stops s = new L1184_Distance_Between_Bus_Stops();
        long sysDate1 = System.currentTimeMillis();

        int[] distance = {1, 2, 3, 4};
        int start = 0;
        int destination = 2;

        int res = s.distanceBetweenBusStops(distance, start, destination);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}