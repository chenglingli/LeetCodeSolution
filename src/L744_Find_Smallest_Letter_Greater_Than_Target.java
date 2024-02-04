public class L744_Find_Smallest_Letter_Greater_Than_Target {

    /*
    2 <= letters.length <= 104
    letters[i] is a lowercase English letter.
    letters is sorted in non-decreasing order.
    letters contain at least two different characters.
    target is a lowercase English letter.
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0;
        while (i < letters.length && letters[i] <= target) {
            i++;
        }
        if (i < letters.length) {
            return letters[i];
        }
        return letters[0];
    }

    public static void main(String[] args) {

        L744_Find_Smallest_Letter_Greater_Than_Target s = new L744_Find_Smallest_Letter_Greater_Than_Target();
        long sysDate1 = System.currentTimeMillis();

        char[] letters = {'c', 'f', 'j'};
        char target = 'z';

        char res = s.nextGreatestLetter(letters, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}