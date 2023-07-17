public class L2000_Reverse_Prefix_of_Word {


    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int index = word.indexOf(ch);
        if (index <= 0) {
            return word;
        }

        for (int i = index ; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        if (index < word.length() -1) {
            sb.append(word.substring(index + 1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        L2000_Reverse_Prefix_of_Word s = new L2000_Reverse_Prefix_of_Word();
        long sysDate1 = System.currentTimeMillis();

        String word = "abcdef";
        char ch = 'e';
        String res = s.reversePrefix(word, ch);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}