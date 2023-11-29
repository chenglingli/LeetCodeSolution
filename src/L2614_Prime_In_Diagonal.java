public class L2614_Prime_In_Diagonal {

    /*
    1 <= nums.length <= 300
    nums.length == numsi.length
    1 <= nums[i][j] <= 4*10^6
     */
    public int diagonalPrime(int[][] nums) {

        int len = nums.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            int temp = nums[i][i];
            if (temp > ans && prime(temp)) {
                ans = temp;
            }
            temp = nums[i][len - i - 1];
            if (temp > ans && prime(temp)) {
                ans = temp;
            }
        }

        return ans;
    }

    private boolean prime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L2614_Prime_In_Diagonal s = new L2614_Prime_In_Diagonal();
        long sysDate1 = System.currentTimeMillis();

        //        int[][] nums = {{1, 2, 3}, {5, 17, 7}, {9, 11, 10}};
        int[][] nums = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int res = s.diagonalPrime(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}