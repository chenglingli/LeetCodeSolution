
public class L278_First_Bad_Version {

    public int firstBadVersion(int n) {

        int low = 1, high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // 无意义，仅仅是为了能够编译通过！
    private boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {

        L278_First_Bad_Version s = new L278_First_Bad_Version();

        long sysDate1 = System.currentTimeMillis();
        int res = s.firstBadVersion(10);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}