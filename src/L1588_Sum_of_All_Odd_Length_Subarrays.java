public class L1588_Sum_of_All_Odd_Length_Subarrays {


    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, answer = 0;

        for (int i = 0; i < n; ++i) {
            int left = i, right = n - i - 1;
            answer += arr[i] * (left / 2 + 1) * (right / 2 + 1);
            answer += arr[i] * ((left + 1) / 2) * ((right + 1) / 2);
        }

        return answer;
    }

    public static void main(String[] args) {

        L1588_Sum_of_All_Odd_Length_Subarrays s =
                new L1588_Sum_of_All_Odd_Length_Subarrays();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {1, 2, 3, 4, 5, 6,7,8}; //98
        //        int[] arr = {1, 2, 3}; // 6
        //        int[] arr = {1, 4, 2, 5, 3}; // 58
        //        int[] arr = {6, 9, 14, 5, 3, 8, 7, 12, 13, 1}; // 878

        int res = s.sumOddLengthSubarrays(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}