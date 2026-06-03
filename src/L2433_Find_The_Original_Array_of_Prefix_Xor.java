import java.util.Arrays;

public class L2433_Find_The_Original_Array_of_Prefix_Xor {

    /*

    You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:

    pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
    Note that ^ denotes the bitwise-xor operation.

    It can be proven that the answer is unique.



    Example 1:

    Input: pref = [5,2,0,3,1]
    Output: [5,7,2,3,2]
    Explanation: From the array [5,7,2,3,2] we have the following:
    - pref[0] = 5.
    - pref[1] = 5 ^ 7 = 2.
    - pref[2] = 5 ^ 7 ^ 2 = 0.
    - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
    - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
    Example 2:

    Input: pref = [13]
    Output: [13]
    Explanation: We have pref[0] = arr[0] = 13.


    Constraints:

    1 <= pref.length <= 10^5
    0 <= pref[i] <= 10^6

     */
    public int[] findArray(int[] pref) {

        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i - 1] ^ pref[i];
        }

        return arr;
    }

    public static void main(String[] args) {

        L2433_Find_The_Original_Array_of_Prefix_Xor s = new L2433_Find_The_Original_Array_of_Prefix_Xor();
        long sysDate1 = System.currentTimeMillis();

        int[] pref = {5, 2, 0, 3, 1};
        int[] res = s.findArray(pref);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}