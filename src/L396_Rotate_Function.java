public class L396_Rotate_Function {

    /*

    F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
    F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
    F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
    F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

    F(0) = (0 * a) + (1 * b) + (2 * c) + (3 * d) + (4 * e) = 0 + b + 2c + 3d + 4e
    F(1) = (1 * a) + (2 * b) + (3 * c) + (4 * d) + (0 * e) = a + 2b + 3c + 4d + 0
    F(2) = (2 * a) + (3 * b) + (4 * c) + (0 * d) + (1 * e) = 2a + 3b + 4c + 0 + e

    Now subtracting 2 equations,

    F(1) - F(0) = a + b + c + d - 4e = a + b + c + d + e - 5e
    Therefore, F(1) = F(0) + a + b + c + d + e - 5e = F(0) + SUM - N*e

    F(2) - F(1) = a + b + c + e - 4d = a + b + c + d + e - 5d
    Therefore, F(2) = F(1) + a + b + c + d + e - 5d = F(1) + SUM - N*d

    Generalizing it, we get the following relation:

    F(K) = F(K-1) + SUM - N * (( K-1)th element from end of array)
    i.e. F(K) = F(K-1) + SUM - N * (array [N - 1 - (K-1)]) = F(K-1) + SUM - N * (array [N - K])



    f[k] = f[k-1] + sum - n*nums[n-k]

     */
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int x : nums) {
            sum += x;
        }

        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[0] += i * nums[i];
        }
        int ans = f[0];

        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + sum - n * nums[n - i];
            ans = Math.max(f[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {

        L396_Rotate_Function s = new L396_Rotate_Function();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 3, 2, 6};
        int res = s.maxRotateFunction(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}