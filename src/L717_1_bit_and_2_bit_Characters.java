import java.util.Arrays;

public class L717_1_bit_and_2_bit_Characters {

    /*

    We have two special characters:

    The first character can be represented by one bit 0.
    The second character can be represented by two bits (10 or 11).
    Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.



    Example 1:

    Input: bits = [1,0,0]
    Output: true
    Explanation: The only way to decode it is two-bit character and one-bit character.
    So the last character is one-bit character.

    Example 2:
    Input: bits = [1,1,1,0]
    Output: false
    Explanation: The only way to decode it is two-bit character and two-bit character.
    So the last character is not one-bit character.


    Constraints:

    1 <= bits.length <= 1000
    bits[i] is either 0 or 1.

     */
    public boolean isOneBitCharacter(int[] bits) {

        // 思路
        // 1. 遍历数组，如果当前位是0，则i++
        //    如果是1，则i+=2;
        // 2. 如果最后一位是0，则为true；否则为false

        int i = 0;
        for (i = 0; i < bits.length - 1;) {
            if (bits[i] == 1) {
                i += 2;
            }
            else {
                i++;
            }
        }

        if (i == bits.length - 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {

        L717_1_bit_and_2_bit_Characters s = new L717_1_bit_and_2_bit_Characters();
        long sysDate1 = System.currentTimeMillis();

        int[] bits = {1, 0, 0};

        boolean res = s.isOneBitCharacter(bits);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}