import java.util.HashSet;
import java.util.Set;

public class L804_Unique_Morse_Code_Words {

    /**
     *

     International Morse Code defines a standard encoding where
     each letter is mapped to a series of dots and dashes,
     as follows: "a" maps to ".-", "b" maps to "-...", "c"
     maps to "-.-.", and so on.

     For convenience, the full table for the 26 letters
     of the English alphabet is given below:

     [".-","-...","-.-.","-..",".","..-.","--.","....","..",
     ".---","-.-",".-..","--","-.","---",".--.","--.-",
     ".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     Now, given a list of words, each word can
     be written as a concatenation of the Morse code of each letter.
     For example, "cba" can be written as "-.-..--...",
     (which is the concatenation "-.-." + "-..." + ".-"). We'll
     call such a concatenation, the transformation of a word.

     Return the number of different transformations
     among all words we have.

     Example:
     Input: words = ["gin", "zen", "gig", "msg"]
     Output: 2

     Explanation:
     The transformation of each word is:
     "gin" -> "--...-."
     "zen" -> "--...-."
     "gig" -> "--...--."
     "msg" -> "--...--."

     There are 2 different transformations, "--...-." and "--...--.".
     Note:

     The length of words will be at most 100.
     Each words[i] will have length in range [1, 12].
     words[i] will only consist of lowercase letters.

     */


    public int uniqueMorseRepresentations2(String[] words) {
        if(words == null || words.length == 0)
            return 0;
        Set<String> set = new HashSet();
        for(String word : words){
            set.add(computeMorseCode(word));
        }
        return set.size();
    }

    private String computeMorseCode(String word){
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder morseCode = new StringBuilder();
        for(char c : word.toCharArray()){
            morseCode.append(codes[c-'a']);
        }
        return morseCode.toString();
    }


    public int uniqueMorseRepresentations(String[] words) {
        if(words == null || words.length == 0)
            return 0;

        String [] codeList = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> hs = new HashSet<>();

        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                sb.append(codeList[c - 'a']);
            }
            hs.add(sb.toString());
        }

        return hs.size();
    }

    public static void main(String[] args) {

        L804_Unique_Morse_Code_Words s = new L804_Unique_Morse_Code_Words();
        long sysDate1 = System.currentTimeMillis();

        String []t = {"gin", "zen", "gig", "msg"};
        int res = s.uniqueMorseRepresentations(t);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}