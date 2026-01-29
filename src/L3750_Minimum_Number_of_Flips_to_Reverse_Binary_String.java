public class L3750_Minimum_Number_of_Flips_to_Reverse_Binary_String {

    /*
    You are given a positive integer n.

    Let s be the binary representation of n without leading zeros.
    
    The reverse of a binary string s is obtained by writing the characters of s in the opposite order.
    
    You may flip any bit in s (change 0 → 1 or 1 → 0). Each flip affects exactly one bit.
    
    Return the minimum number of flips required to make s equal to the reverse of its original form.
    
     
    
    Example 1:
    
    Input: n = 7
    
    Output: 0
    
    Explanation:
    
    The binary representation of 7 is "111". Its reverse is also "111", which is the same. Hence, no flips are needed.
    
    Example 2:
    
    Input: n = 10
    
    Output: 4
    
    Explanation:
    
    The binary representation of 10 is "1010". Its reverse is "0101". All four bits must be flipped to make them equal. Thus, the minimum number of flips required is 4.
    
     
    
    Constraints:
    
    1 <= n <= 10^9

     */
    public int minimumFlips(int n) {
        // 获取n的二进制表示字符串，再获取其翻转后的表示字符串，然后比较两者，统计不同位的数量

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public int minimumFlips2(int n) {

        String str = Integer.toBinaryString(n);

        int flips = 0;
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                flips += 2;
            }
            left++;
            right--;
        }
        return flips;

    }

    public static void main(String[] args) {

        L3750_Minimum_Number_of_Flips_to_Reverse_Binary_String s = new L3750_Minimum_Number_of_Flips_to_Reverse_Binary_String();
        long sysDate1 = System.currentTimeMillis();

        int num = 10;
        int res = s.minimumFlips(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}