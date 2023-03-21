import java.util.ArrayList;
import java.util.List;

public class L1704_Determine_if_String_Halves_Are_Alike {


    public boolean halvesAreAlike(String s) {
        int count = 0;
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i = 0 ; i < s.length() /2 ; i++) {
            char cur = s.charAt(i);
            if (cur <= 'Z') {
                cur += 'a' - 'A';
            }

            if(vowels.contains(cur)) {
                count++;
            }
        }

        for(int i = s.length() /2 ; i < s.length() ; i++) {
            char cur = s.charAt(i);
            if (cur <= 'Z') {
                cur += 'a' - 'A';
            }
            if(vowels.contains(cur)) {
                count--;
            }
        }

        return count == 0;
    }

    public boolean halvesAreAlike2(String s)
    {
        int len = s.length();
        int mid = len/2;
        int count1 = countVowels(s.substring(0, mid));
        int count2 = countVowels(s.substring(mid, len));
        return count1 == count2;
    }

    static int countVowels(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
            ){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L1704_Determine_if_String_Halves_Are_Alike s = new L1704_Determine_if_String_Halves_Are_Alike();
        long sysDate1 = System.currentTimeMillis();

        String ss = "AbCdEfGh";
        boolean res = s.halvesAreAlike(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}