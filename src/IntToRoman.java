
/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*/


public class IntToRoman {


    public String intToRoman(int num) {

        int [] romInt = {1000, 900, 500, 400, 100,
                90, 50, 40, 10,
                9, 5, 4, 1};
        String [] romChar = {"M", "CM", "D", "CD", "C",
                "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};

        StringBuilder tempRes = new StringBuilder();

        int i = 0;
        while (i < romChar.length ) {
            while (num >= romInt[i]) {
                tempRes.append(romChar[i]);
                num = num - romInt[i];
            }
            i++;
        }

        return tempRes.toString();
    }


    public static void main(String[] args) {

        IntToRoman s = new IntToRoman();

        long sysDate1 = System.currentTimeMillis();

        int input = 1994;
        String res = s.intToRoman(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}