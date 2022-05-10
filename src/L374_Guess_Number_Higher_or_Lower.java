public class L374_Guess_Number_Higher_or_Lower {

    public int guessNumber(int n) {

        int low = 1, high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            int t = guess(mid);

            if (t == 0) {
                return mid;
            } else if (t == -1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    int guess(int num) {
        int x = 6;
        if (num == x) {
            return 0;
        } else if (num > x) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {

        L374_Guess_Number_Higher_or_Lower s = new L374_Guess_Number_Higher_or_Lower();

        long sysDate1 = System.currentTimeMillis();
        int res = s.guessNumber(10);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}