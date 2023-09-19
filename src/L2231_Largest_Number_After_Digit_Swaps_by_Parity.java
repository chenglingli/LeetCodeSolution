public class L2231_Largest_Number_After_Digit_Swaps_by_Parity {

    /*
    1 <= num <= 10^9
     */
    public int largestInteger(int num) {

        int len = (int) (Math.log10(num) + 1);

        int[] arr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] % 2 == 0 && arr[j] % 2 == 0 && arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

                if (arr[i] % 2 == 1 && arr[j] % 2 == 1 && arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++)
            ans = ans * 10 + arr[i];
        return ans;
    }

    public int largestInteger2(int num) {

        char[] nums = Integer.toString(num).toCharArray();

        // Calculate the frequency of each digit from 0 - 9
        int[] frequency = new int[10];
        for (char c : nums) {
            frequency[c - '0']++;
        }

        int newNumber = 0;
        int evenIndex = 8; // corresponds to the number 8
        int oddIndex = 9; // corresponds to the number 9

        // construct the number
        for (char c : nums) {
            // If the parity of number in current index is even
            if (c % 2 == 0) {
                // Get first even digit of non-zero frequency
                while (frequency[evenIndex] == 0) {
                    evenIndex -= 2;
                }
                frequency[evenIndex]--;
                newNumber = newNumber * 10 + evenIndex;
            } else {
                // If the parity of number in current index is odd
                // Get first odd digit of non-zero frequency
                while (frequency[oddIndex] == 0) {
                    oddIndex -= 2;
                }
                frequency[oddIndex]--;
                newNumber = newNumber * 10 + oddIndex;
            }
        }

        return newNumber;
    }

    public static void main(String[] args) {

        L2231_Largest_Number_After_Digit_Swaps_by_Parity s =
                new L2231_Largest_Number_After_Digit_Swaps_by_Parity();
        long sysDate1 = System.currentTimeMillis();

        //        int num = 12345;
        int num = 247;
        int res = s.largestInteger2(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}