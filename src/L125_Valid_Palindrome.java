/*
字符串法
public class L944_Delete_Columns_to_Make_Sorted {
    public boolean isPalindrome(int x) {

        int tempX = x;
        if (tempX < 0 ) {
            return false;
        }

        char [] intChar = new char[20];
        int i = 0, j = 0;
        while (tempX > 0) {
            intChar[i++] = (char)(tempX % 10);
            tempX /= 10;
        }
        int len = i;

        i = 0;
        j = len - 1;
        while ( i < j) {
            if (intChar[i++] != intChar[j--]) return false;
        }

        return true;
    }
}

 */

/*

int 法，比较两个int是否一样大

public class L944_Delete_Columns_to_Make_Sorted {

    public boolean isPalindrome(int x) {
        long y = x;
        long a = 0;

        if (x < 0) return false;

        while (x > 0) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        if (a > Integer.MAX_VALUE) return false;
        if (a == y) {
            return true;
        } else {
            return false;
        }
    }
}
 */

public class L125_Valid_Palindrome {

    public boolean isPalindrome(int x) {
        long y = x;
        long a = 0;

        if (x < 0) return false;

        while (x > 0) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        if (a > Integer.MAX_VALUE) return false;
        if (a == y) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        L125_Valid_Palindrome s = new L125_Valid_Palindrome();
        // int x = 1534236469;
        // int x = -123;
        int x = 1;
        // int y = -2147483648;

        long sysDate1 = System.currentTimeMillis();

        boolean res = s.isPalindrome(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();

        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

